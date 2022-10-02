package com.mihael.bookStore.restcontrollers;

import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;
import com.mihael.bookStore.services.customer.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
    private final CustomerManagementService customerService;

    @Autowired
    public CustomerRestController(CustomerManagementService customerService){
        this.customerService = customerService;
    }

    @RequestMapping("/customer/{id}")
    public Customer findCustomerById(@PathVariable String id) throws CustomerNotFoundException {
        return customerService.findCustomerById(Long.valueOf(id));
    }
}
