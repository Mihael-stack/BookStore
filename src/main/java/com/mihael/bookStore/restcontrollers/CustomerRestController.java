package com.mihael.bookStore.restcontrollers;

import com.mihael.bookStore.client.Client;
import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;
import com.mihael.bookStore.representations.CustomerCollectionRepresentation;
import com.mihael.bookStore.restcontrollers.errorhandlers.ClientErrorInformation;
import com.mihael.bookStore.services.customer.CustomerManagementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Customer findCustomerById(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/customers")
    public CustomerCollectionRepresentation returnAllCustomers() throws CustomerNotFoundException {
        return new CustomerCollectionRepresentation(this.customerService.getAllCustomers());
    }

    @PostMapping("/customers")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createNewCustomer(@RequestBody Customer newCustomer) throws CustomerAlreadyExistWithProvidedEmailException {
        try {
            this.customerService.addNewCustomer(newCustomer);
        }
        catch (DataIntegrityViolationException e){
            throw new CustomerAlreadyExistWithProvidedEmailException("Customer already exists with such email");
        }
    }
}
