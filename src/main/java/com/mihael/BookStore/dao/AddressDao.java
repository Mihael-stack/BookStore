package com.mihael.BookStore.dao;

import com.mihael.BookStore.entity.Address;

public interface AddressDao {
    public void addAddress(Address address);
    public Address findById(int id);
    public void updateAddress(Address newAddress);
}
