package com.mihael.BookStore.services.address;

import com.mihael.BookStore.dao.address.AddressDao;
import com.mihael.BookStore.dao.address.AddressDaoJPAProduction;
import com.mihael.BookStore.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AddressManagementServiceProductionImpl implements AddressManagementService{
    @Autowired
    private AddressDao dao;

    @Override
    public Address addNewAddress(Address address) {
        return dao.addAddress(address);
    }

}
