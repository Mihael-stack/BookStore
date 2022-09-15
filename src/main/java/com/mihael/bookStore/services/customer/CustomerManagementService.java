package com.mihael.bookStore.services.customer;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Customer;

public interface CustomerManagementService {
    void addNewCustomer(Customer customer);
    Customer findCustomerById(int id);
    Customer findCustomerByEmail(String email);
    void updateCustomer(Customer newCustomer);
    void removeCustomer(Customer removeCustomer);
    void addNewCustomerWithAddress(Customer customer, Address address);
}
