package com.mihael.bookStore.representations;

import com.mihael.bookStore.entity.Customer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@XmlRootElement(name = "customers")
public class CustomerCollectionRepresentation {
    private List<CustomerRepresentation> customers;

    public CustomerCollectionRepresentation(){} // NOTE: The httpMessageConvertor for xml needs an empty no-args constructor.

    public CustomerCollectionRepresentation(List<Customer> customers) {
        this.customers = new ArrayList<>();
        for (Customer customer : customers) {
            this.customers.add(new CustomerRepresentation(customer));
        }

    }

    @XmlElement(name = "customer")
    public List<CustomerRepresentation> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerRepresentation> customers) {
        this.customers = customers;
    }
}
