package com.mihael.bookStore.services.address;

import com.mihael.bookStore.entity.Address;

public interface AddressManagementService {
    Address addNewAddress(Address address);
    void updateAddress(Address newAddress);
}
