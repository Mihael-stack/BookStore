package com.mihael.bookStore.restcontrollers;

import com.mihael.bookStore.client.Client;
import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;
import com.mihael.bookStore.representations.CustomerCollectionRepresentation;
import com.mihael.bookStore.representations.CustomerRepresentation;
import com.mihael.bookStore.restcontrollers.errorhandlers.ClientErrorInformation;
import com.mihael.bookStore.services.customer.CustomerManagementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class CustomerRestController {
    private final CustomerManagementService customerService;
    static Log logger = LogFactory.getLog(Client.class);
    @Autowired
    public CustomerRestController(CustomerManagementService customerService){
        this.customerService = customerService;
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ClientErrorInformation> rulesForCustomerNotFound(Exception e){
        ClientErrorInformation error = new ClientErrorInformation(e.toString());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CustomerAlreadyExistWithProvidedEmailException.class)
    public ResponseEntity<ClientErrorInformation> rulesForCustomerAlreadyExistsWithEmail(Exception e){
        ClientErrorInformation error = new ClientErrorInformation(e.toString());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/customer/{id}")
    public CustomerRepresentation findCustomerById(@PathVariable Long id) throws CustomerNotFoundException {
        return new CustomerRepresentation(customerService.findCustomerById(id));
    }

    @GetMapping("/customers")
    public CustomerCollectionRepresentation returnAllCustomers() throws CustomerNotFoundException {
        CustomerCollectionRepresentation customers = new CustomerCollectionRepresentation(this.customerService.getAllCustomers());

        for(CustomerRepresentation customer : customers.getCustomers()) {
            Link link = linkTo(methodOn(CustomerRestController.class).findCustomerById(customer.getId())).withSelfRel();
            customer.add(link);
        }

        return customers;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerRepresentation createNewCustomer(@RequestBody Customer newCustomer) throws CustomerAlreadyExistWithProvidedEmailException, CustomerNotFoundException {
        Link link;
        CustomerRepresentation createdCustomer;
        try {
            this.customerService.addNewCustomer(newCustomer);
            createdCustomer = new CustomerRepresentation(this.customerService.findCustomerByEmail(newCustomer.getEmailAddress()));
            link = linkTo(methodOn(CustomerRestController.class).findCustomerById(createdCustomer.getId())).withSelfRel();
            createdCustomer.add(link);
        } catch (DataIntegrityViolationException e) {
            throw new CustomerAlreadyExistWithProvidedEmailException("Customer already exists with such email");
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException("createNewCustomer invoked this exception, most likely due to HATEOAS");
        }


        return createdCustomer;
    }
}
