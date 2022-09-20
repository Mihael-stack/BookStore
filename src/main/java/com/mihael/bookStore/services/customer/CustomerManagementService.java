package com.mihael.bookStore.services.customer;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;

public interface CustomerManagementService {
    void addNewCustomer(Customer customer) throws CustomerAlreadyExistWithProvidedEmailException;
    void addNewCustomerWithAddress(Customer customer, Address address) throws CustomerAlreadyExistWithProvidedEmailException;
    Customer findCustomerById(Long id) throws CustomerNotFoundException;
    Customer findCustomerByEmail(String email) throws CustomerNotFoundException;
    void updateCustomer(Customer newCustomer);
    void updateCustomerWithAddress(Customer newCustomer, Address newAddress);
    void removeCustomer(Customer removeCustomer) throws CustomerNotFoundException;
    void removeAddressFromCustomer(Customer customer,Address address);

}
