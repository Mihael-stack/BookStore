package com.mihael.bookStore.dao.customer;

import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class CustomerDaoJPAProduction implements CustomerDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCustomer(Customer customer) {
        try {
            this.em.persist(customer);
        }catch (CustomerAlreadyExistWithProvidedEmailException e){
            throw new CustomerAlreadyExistWithProvidedEmailException();
        }
    }

    @Override
    public Customer findCustomerById(int id) throws CustomerNotFoundException {
        Customer customer = this.em.find(Customer.class, id);
        if(customer == null){
            throw new CustomerNotFoundException("Exception was thrown because query returned null, CustomerDaoJPAProduction.class");
        }else return customer;
    }

    @Override
    public Customer findCustomerByEmail(String emailAddress) throws CustomerNotFoundException {
        try {
            return (Customer) this.em.createQuery("SELECT customer FROM Customer as customer WHERE customer.emailAddress=:emailAddress")
                    .setParameter("emailAddress", emailAddress).getSingleResult();
        }
        catch (javax.persistence.NoResultException e){
            throw new CustomerNotFoundException("Costumer not found. The costumer was deleted or you have a typo in your search parameters");
        }
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
    }

}
