package com.mihael.BookStore.dao.address;

import com.mihael.BookStore.entity.Address;

public interface AddressDao {
    public Address addAddress(Address address);
    public Address findById(int id);
    public void updateAddress(Address newAddress);
}
