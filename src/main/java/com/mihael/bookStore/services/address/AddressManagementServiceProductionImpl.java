package com.mihael.bookStore.services.address;

import com.mihael.bookStore.dao.address.AddressDao;
import com.mihael.bookStore.entity.Address;
//import org.springframework.beans.factory.annotation.Autowired;
import com.mihael.bookStore.exceptions.AddressNotFoundException;
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

    @Override
    public void updateAddress(Address newAddress) {
        this.dao.updateAddress(newAddress);
    }

    @Override
    public void deleteAddress(Address address) {
        dao.deleteAddress(address);
    }

    @Override
    public Address findAddress(long id) throws AddressNotFoundException {
        try {
            return dao.findById(id);
        }catch (AddressNotFoundException e){
            throw new AddressNotFoundException(e.toString());
        }

    }
}
