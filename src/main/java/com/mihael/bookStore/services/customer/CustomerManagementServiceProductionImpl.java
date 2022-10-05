package com.mihael.bookStore.services.customer;

import com.mihael.bookStore.dao.customer.CustomerDao;
import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;
import com.mihael.bookStore.services.address.AddressManagementService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CustomerManagementServiceProductionImpl implements CustomerManagementService{
    private final CustomerDao dao;
    private final AddressManagementService addressService;

    public CustomerManagementServiceProductionImpl(CustomerDao dao, AddressManagementService addressService){
        this.dao = dao;
        this.addressService = addressService;
    }
    @Transactional(rollbackFor = {CustomerAlreadyExistWithProvidedEmailException.class, DataIntegrityViolationException.class})
    @Override
    public void addNewCustomer(Customer customer) throws CustomerAlreadyExistWithProvidedEmailException {
        try {// TODO: Try to handel it in the controller
            dao.addCustomer(customer);
        }catch (CustomerAlreadyExistWithProvidedEmailException | DataIntegrityViolationException e){
            throw new CustomerAlreadyExistWithProvidedEmailException("Email Already Exists!, AddNewCustomer-CustomerManagementService");
        }
    }

    @Transactional(rollbackFor = {CustomerAlreadyExistWithProvidedEmailException.class, DataIntegrityViolationException.class})
    @Override
    public void addNewCustomerWithAddress(Customer customer, Address address) throws CustomerAlreadyExistWithProvidedEmailException {
        try { // TODO: Try to handel it in the controller
            this.addressService.addNewAddress(address);
            customer.setAddress(address);
            this.dao.addCustomer(customer);
        }catch (CustomerAlreadyExistWithProvidedEmailException | DataIntegrityViolationException e){
            throw new CustomerAlreadyExistWithProvidedEmailException("Email Already Exists!, AddNewCustomerWithAddress-CustomerManagementService");

        }

    }

    @Override
    public Customer findCustomerById(Long id) throws CustomerNotFoundException {
        try {
            return this.dao.findCustomerById(id);
        }catch (CustomerNotFoundException e){
            throw new CustomerNotFoundException(e.toString());
        }
    }

    @Override
    public Customer findCustomerByEmail(String email) throws CustomerNotFoundException {
        try{
            return this.dao.findCustomerByEmail(email);
        }catch (CustomerNotFoundException e){
            throw new CustomerNotFoundException(e.toString());
        }
    }

    @Override
    public void updateCustomer(Customer newCustomer) {
        this.dao.updateCustomer(newCustomer);

    }
    public void updateCustomerWithAddress(Customer newCustomer, Address newAddress) {
        this.addressService.updateAddress(newAddress);
        this.dao.updateCustomer(newCustomer);
    }

    @Override
    public void removeCustomer(Customer removeCustomer) throws CustomerNotFoundException {
        this.dao.deleteCustomerByEmail(removeCustomer);
    }
    public void removeAddressFromCustomer(Customer customer, Address address){
        customer.setAddress(null);
        this.addressService.deleteAddress(address);
    }

    @Override
    public List<Customer> getAllCustomers() throws CustomerNotFoundException {
        return this.dao.getAllCustomers();
    }

}
