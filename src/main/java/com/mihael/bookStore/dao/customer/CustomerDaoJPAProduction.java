package com.mihael.bookStore.dao.customer;

import com.mihael.bookStore.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class CustomerDaoJPAProduction implements CustomerDao{
    @PersistenceContext
    private EntityManager em;

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
        return (Customer)this.em.createQuery("SELECT customer FROM Customer as customer WHERE customer.emailAddress=:emailAddress")
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
