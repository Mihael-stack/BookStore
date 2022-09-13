package com.mihael.BookStore.services.customer;

import com.mihael.BookStore.dao.customer.CustomerDao;
import com.mihael.BookStore.dao.customer.CustomerDaoJPAProduction;
import com.mihael.BookStore.entity.Address;
import com.mihael.BookStore.entity.Customer;
import com.mihael.BookStore.services.address.AddressManagementService;
import com.mihael.BookStore.services.address.AddressManagementServiceProductionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CustomerManagementServiceProductionImpl implements CustomerManagementService{
    @Autowired
    private CustomerDao dao;
    @Autowired
    private AddressManagementService addressService;

    @Override
    public void addNewCustomer(Customer customer) {
        dao.addCustomer(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return dao.findCustomerById(id);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return dao.findCustomerByEmail(email);
    }

    @Override
    public void updateCustomer(Customer newCustomer) {
        dao.updateCustomer(newCustomer);
    }

    @Override
    public void removeCustomer(Customer removeCustomer) {
        dao.deleteCustomer(removeCustomer);
    }

    @Override
    public void addNewCustomerWithAddress(Customer customer, Address address) {
        addressService.addNewAddress(address);
        customer.setAddress(address);
        dao.addCustomer(customer);
    }



}
