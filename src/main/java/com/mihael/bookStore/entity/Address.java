package com.mihael.bookStore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private String city;
    private String country;
    private String postalCode;
    private String state;

    //Hibernate needs an empty constructor
    public Address(){}

    public Address(String street, String city, String country, String postalCode, String state){
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street=" + street +
                ", city=" + city +
                ", country=" + country +
                ", postalCode=" + postalCode +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
