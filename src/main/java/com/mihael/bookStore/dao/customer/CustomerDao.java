package com.mihael.bookStore.dao.customer;

import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;

public interface CustomerDao {
    void addCustomer(Customer customer) throws CustomerAlreadyExistWithProvidedEmailException;
    Customer findCustomerById(Long id) throws CustomerNotFoundException;
    Customer findCustomerByEmail(String emailAddress) throws CustomerNotFoundException;
    void deleteCustomerById(Customer customer) throws CustomerNotFoundException;
    void deleteCustomerByEmail(Customer customer) throws CustomerNotFoundException;
    void updateCustomer(Customer newCustomer);
}
