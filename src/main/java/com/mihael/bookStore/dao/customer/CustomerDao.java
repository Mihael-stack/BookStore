package com.mihael.bookStore.dao.customer;

import com.mihael.bookStore.entity.Customer;

public interface CustomerDao {
    void addCustomer(Customer customer);
    Customer findCustomerById(int id);
    Customer findCustomerByEmail(String emailAddress);
    void deleteCustomer(Customer customer);
    void updateCustomer(Customer newCustomer);
}
