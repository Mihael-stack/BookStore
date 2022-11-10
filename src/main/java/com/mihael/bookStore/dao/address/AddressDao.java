package com.mihael.bookStore.dao.address;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.exceptions.AddressNotFoundException;

public interface AddressDao {
    void addAddress(Address address);
    Address findById(Long id) throws AddressNotFoundException;
    void updateAddress(Address newAddress);

    void deleteAddress(Address address);
}
