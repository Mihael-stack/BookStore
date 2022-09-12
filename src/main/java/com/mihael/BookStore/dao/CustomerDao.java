package com.mihael.BookStore.dao;

import com.mihael.BookStore.entity.Customer;

public interface CustomerDao {
    public Customer addCustomer(Customer customer);
    public Customer findCustomerById(int id);
    public void deleteCustomer(Customer customer);
    public void updateCustomer(Customer newCustomer);
}
