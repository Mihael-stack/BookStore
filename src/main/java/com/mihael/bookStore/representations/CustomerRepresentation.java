package com.mihael.bookStore.representations;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Customer;
import org.springframework.hateoas.RepresentationModel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
public class CustomerRepresentation extends RepresentationModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Address address;

    public CustomerRepresentation(){}

    public CustomerRepresentation(Long id, String firstName, String lastName, String emailAddress, Address address){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
    }
    public CustomerRepresentation(Customer customer){
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.emailAddress = customer.getEmailAddress();
        this.address = customer.getAddress();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
