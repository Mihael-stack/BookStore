package com.mihael.BookStore.services.address;

import com.mihael.BookStore.dao.address.AddressDao;
import com.mihael.BookStore.entity.Address;

public class AddressManagementServiceProductionImpl implements AddressManagementService{

    private AddressDao dao;

    public AddressManagementServiceProductionImpl(AddressDao dao){
        this.dao = dao;
    }

    @Override
    public Address addNewAddress(Address address) {
        return dao.addAddress(address);
    }
}
