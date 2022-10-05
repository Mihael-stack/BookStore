package com.mihael.bookStore.dao.customer;

import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class CustomerDaoJPAProduction implements CustomerDao{
    @PersistenceContext
    private EntityManager em;

    @Transactional(rollbackFor = {CustomerAlreadyExistWithProvidedEmailException.class, DataIntegrityViolationException.class})
    @Override
    public void addCustomer(Customer customer) throws CustomerAlreadyExistWithProvidedEmailException{
        try {// TODO: Try to handel it in the controller
           this.em.persist(customer);
        }catch (DataIntegrityViolationException e){
            throw new CustomerAlreadyExistWithProvidedEmailException("Already exists");
        }

    }

    @Override
    public Customer findCustomerById(Long id) throws CustomerNotFoundException {
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
    public void deleteCustomerById(Customer customer) throws CustomerNotFoundException {
            Customer persisCustomer = findCustomerById(customer.getId());
            this.em.remove(persisCustomer);
    }
    @Override
    public void deleteCustomerByEmail(Customer customer) throws CustomerNotFoundException {
        Customer persisCustomer = findCustomerByEmail(customer.getEmailAddress());
        this.em.remove(persisCustomer);
        //java.lang.IllegalArgumentException:
    }

    @Override
    public void updateCustomer(Customer newCustomer) {
        Customer oldCustomer = this.em.find(Customer.class,newCustomer.getId());
        oldCustomer.setEmailAddress(newCustomer.getEmailAddress());
        oldCustomer.setFirstName(newCustomer.getFirstName());
        oldCustomer.setLastName(newCustomer.getLastName());
    }

    @Override
    public List<Customer> getAllCustomers() throws CustomerNotFoundException {
        List<Customer> list = em.createQuery("SELECT customer FROM Customer as customer", Customer.class).getResultList();
        if(list.isEmpty()){
            throw new CustomerNotFoundException("The Customer database is empty");
        }
        else return list;
    }

}
