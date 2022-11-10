package com.mihael.bookStore.dao.address;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.exceptions.AddressNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class AddressDaoJPAProduction implements AddressDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addAddress(Address address) {
        this.em.persist(address);
    }

    @Override
    public Address findById(Long id) throws AddressNotFoundException {
        Address address = this.em.find(Address.class, id);
        if(address == null){
            throw new AddressNotFoundException("Address does not exist!");
        }else return address;
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

    @Override
    public void deleteAddress(Address address) {
        Address removeAddress = em.find(Address.class,address.getId());
        em.remove(removeAddress);
    }
}
