package com.mihael.bookStore.restcontrollers;

import com.mihael.bookStore.client.Client;
import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;
import com.mihael.bookStore.representations.CustomerCollectionRepresentation;
import com.mihael.bookStore.representations.CustomerRepresentation;
import com.mihael.bookStore.representations.ClientErrorInformation;
import com.mihael.bookStore.services.customer.CustomerManagementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @ExceptionHandler({CustomerAlreadyExistWithProvidedEmailException.class, DataIntegrityViolationException.class})
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
    @GetMapping("/customer/email/{emailAddress}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerRepresentation findCustomerByEmail(@PathVariable String emailAddress) throws CustomerNotFoundException {
        Customer customer = this.customerService.findCustomerByEmail(emailAddress);
        Link link = linkTo(methodOn(CustomerRestController.class).findCustomerById(customer.getId())).withSelfRel();
        CustomerRepresentation foundCustomer = new CustomerRepresentation(customer);
        foundCustomer.add(link);
        return foundCustomer;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerRepresentation createNewCustomer(@RequestBody @Valid Customer newCustomer) throws DataIntegrityViolationException, CustomerAlreadyExistWithProvidedEmailException, CustomerNotFoundException {
        this.customerService.addNewCustomer(newCustomer);
        CustomerRepresentation createdCustomer = new CustomerRepresentation(this.customerService.findCustomerByEmail(newCustomer.getEmailAddress()));
        Link link = linkTo(methodOn(CustomerRestController.class).findCustomerById(createdCustomer.getId())).withSelfRel();
        createdCustomer.add(link);

        return createdCustomer;
    }
    @DeleteMapping("customer/{id}")
    public Link deleteCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        Customer customer = customerService.findCustomerById(id);
        customerService.removeCustomer(customer);
        return linkTo(methodOn(CustomerRestController.class).findCustomerById(id)).withRel("customers");
    }

}
