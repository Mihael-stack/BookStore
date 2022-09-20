package com.mihael.bookStore.entity;

public interface AddressReadOnly {
    Long getId();
    public String getStreet();
    String getCity();
    String getCountry();
    String getPostalCode();
    String getState();
}
