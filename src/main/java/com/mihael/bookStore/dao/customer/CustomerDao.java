package com.mihael.bookStore.dao.customer;

import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;

public interface CustomerDao {
    void addCustomer(Customer customer) throws CustomerAlreadyExistWithProvidedEmailException;
    Customer findCustomerById(int id) throws CustomerNotFoundException;
    Customer findCustomerByEmail(String emailAddress) throws CustomerNotFoundException;
    void deleteCustomer(Customer customer);
    void updateCustomer(Customer newCustomer);
}
