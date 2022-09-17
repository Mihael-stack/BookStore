package com.mihael.bookStore.services.customer;

import com.mihael.bookStore.dao.customer.CustomerDao;
import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;
import com.mihael.bookStore.services.address.AddressManagementService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CustomerManagementServiceProductionImpl implements CustomerManagementService{
    private CustomerDao dao;
    private AddressManagementService addressService;

    public CustomerManagementServiceProductionImpl(CustomerDao dao, AddressManagementService addressService){
        this.dao = dao;
        this.addressService = addressService;
    }
    @Transactional(rollbackFor = CustomerAlreadyExistWithProvidedEmailException.class)
    @Override
    public void addNewCustomer(Customer customer) throws CustomerAlreadyExistWithProvidedEmailException {
        try {
            dao.addCustomer(customer);
        }catch (CustomerAlreadyExistWithProvidedEmailException e){
            throw new CustomerAlreadyExistWithProvidedEmailException(e.toString());
        }
    }

    @Override
    public Customer findCustomerById(int id) throws CustomerNotFoundException {
        try {
            return dao.findCustomerById(id);
        }catch (CustomerNotFoundException e){
            throw new CustomerNotFoundException(e.toString());
        }
    }

    @Override
    public Customer findCustomerByEmail(String email) throws CustomerNotFoundException {
        try{
            return dao.findCustomerByEmail(email);
        }catch (CustomerNotFoundException e){
            throw new CustomerNotFoundException(e.toString());
        }
    }

    @Override
    public void updateCustomer(Customer newCustomer) {
        dao.updateCustomer(newCustomer);

    }
    public void updateCustomerWithAddress(Customer newCustomer, Address newAddress) {
        addressService.updateAddress(newAddress);
        dao.updateCustomer(newCustomer);
    }

    @Override
    public void removeCustomer(Customer removeCustomer) {
        dao.deleteCustomer(removeCustomer);
    }
    @Transactional(rollbackFor = CustomerAlreadyExistWithProvidedEmailException.class)
    @Override
    public void addNewCustomerWithAddress(Customer customer, Address address) throws CustomerAlreadyExistWithProvidedEmailException {
        addressService.addNewAddress(address);
        customer.setAddress(address);
        dao.addCustomer(customer);
    }



}
