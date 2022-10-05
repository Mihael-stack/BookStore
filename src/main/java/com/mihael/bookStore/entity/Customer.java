package com.mihael.bookStore.entity;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String emailAddress;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Address address;

    //Hibernate needs an empty constructor
    public Customer(){}

    public Customer(String firstName, String lastName, String emailAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", emailAddress=" + emailAddress +
                ", address=" + address +
                '}';
    }

    public Long getId() {
        return id;
    }
    //Reminder : -setId- is only for testing purposes
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public Address getAddress() {
        return address;
    } // Use this only if you need to change values of the Address

    public AddressReadOnly getAddressReadOnly() { // note: Json was giving back both Address and AddressReadOnly in data conversion, Fixed with @JsonIgnore, This might be a problem in the future. If address is not given back when it should be, the problem might originate from this annotation
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
