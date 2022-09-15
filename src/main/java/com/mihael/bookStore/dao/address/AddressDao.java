package com.mihael.bookStore.dao.address;

import com.mihael.bookStore.entity.Address;

public interface AddressDao {
    Address addAddress(Address address);
    Address findById(int id);
    void updateAddress(Address newAddress);
}
