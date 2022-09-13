package com.mihael.BookStore.services.customer;

import com.mihael.BookStore.entity.Address;
import com.mihael.BookStore.entity.Customer;

public interface CustomerManagementService {
    public void addNewCustomer(Customer customer);
    public Customer findCustomerById(int id);
    public Customer findCustomerByEmail(String email);
    public void updateCustomer(Customer newCustomer);
    public void removeCustomer(Customer removeCustomer);
    public void addNewCustomerWithAddress(Customer customer, Address address);
}
