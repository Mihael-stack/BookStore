package com.mihael.BookStore.services.customer;

import com.mihael.BookStore.dao.customer.CustomerDao;
import com.mihael.BookStore.entity.Address;
import com.mihael.BookStore.entity.Customer;
import com.mihael.BookStore.services.address.AddressManagementService;

public class CustomerManagementServiceProductionImpl implements CustomerManagementService{

    private CustomerDao dao;
    private AddressManagementService addressService;

    public CustomerManagementServiceProductionImpl(CustomerDao dao, AddressManagementService addressService){
        this.dao = dao;
        this.addressService = addressService;
    }

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
