package com.mihael.BookStore.dao;

import com.mihael.BookStore.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
public class CustomerDaoJPAProduction implements CustomerDao{

    private EntityManager em;

    public CustomerDaoJPAProduction(EntityManager em){
        this.em = em;
    }

    @Override
    public void addCustomer(Customer customer) {
        this.em.persist(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return this.em.find(Customer.class,id);
    }

    @Override
    public Customer findCustomerByEmail(String emailAddress) {
        return (Customer)this.em.createQuery("SELECT customer FROM Customer as customer WHERE customer.id=:emailAddress")
                .setParameter("emailAddress",emailAddress).getSingleResult();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Customer persisCustomer = this.em.find(Customer.class, customer.getId());
        this.em.remove(persisCustomer);
    }

    @Override
    public void updateCustomer(Customer newCustomer) {
        Customer oldCustomer = this.em.find(Customer.class,newCustomer.getId());
        oldCustomer.setEmailAddress(newCustomer.getEmailAddress());
        oldCustomer.setFirstName(newCustomer.getFirstName());
        oldCustomer.setLastName(newCustomer.getLastName());
        // TODO: Update the address as well.
        // oldCustomer.setAddress();
    }
}
