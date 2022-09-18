package com.mihael.bookStore.services.address;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.exceptions.AddressNotFoundException;

public interface AddressManagementService {
    void addNewAddress(Address address);
    void updateAddress(Address newAddress);

    void deleteAddress(Address address);

    Address findAddress(long id) throws AddressNotFoundException;
}
