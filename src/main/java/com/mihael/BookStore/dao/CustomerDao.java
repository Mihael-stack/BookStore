package com.mihael.BookStore.dao;

import com.mihael.BookStore.entity.Customer;

public interface CustomerDao {
    public void addCustomer(Customer customer);
    public Customer findCustomerById(int id);
    public Customer findCustomerByEmail(String emailAddress);
    public void deleteCustomer(Customer customer);
    public void updateCustomer(Customer newCustomer);
}
