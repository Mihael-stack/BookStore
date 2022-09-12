package com.mihael.BookStore.dao;

import com.mihael.BookStore.entity.Customer;

import javax.persistence.EntityManager;

public class CustomerDaoJPAProduction implements CustomerDao{

    private EntityManager em;

    public CustomerDaoJPAProduction(EntityManager em){
        this.em = em;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer findCustomerById(int id) {
        return null;
    }

    @Override
    public void deleteCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(Customer newCustomer) {

    }
}
