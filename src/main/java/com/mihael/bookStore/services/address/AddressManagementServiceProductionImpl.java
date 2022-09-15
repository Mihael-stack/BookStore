package com.mihael.bookStore.services.address;

import com.mihael.bookStore.dao.address.AddressDao;
import com.mihael.bookStore.entity.Address;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AddressManagementServiceProductionImpl implements AddressManagementService{
//    @Autowired
    private AddressDao dao;

    public AddressManagementServiceProductionImpl(AddressDao dao){
        this.dao = dao;
    }

    @Override
    public Address addNewAddress(Address address) {
        return dao.addAddress(address);
    }

}
