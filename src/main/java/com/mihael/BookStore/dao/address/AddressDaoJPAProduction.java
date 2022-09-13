package com.mihael.BookStore.dao.address;

import com.mihael.BookStore.entity.Address;

import javax.persistence.EntityManager;

public class AddressDaoJPAProduction implements AddressDao{
    private EntityManager em;

    public AddressDaoJPAProduction(EntityManager em){
        this.em = em;
    }
    @Override
    public Address addAddress(Address address) {
        this.em.persist(address);
        return address;
    }

    @Override
    public Address findById(int id) {
        return this.em.find(Address.class,id);
    }

    @Override
    public void updateAddress(Address newAddress) {
        Address address = this.em.find(Address.class,newAddress.getId());
        address.setCity(newAddress.getCity());
        address.setState(newAddress.getState());
        address.setCountry(newAddress.getCountry());
        address.setStreet(newAddress.getStreet());
        address.setPostalCode(newAddress.getPostalCode());

    }
}
