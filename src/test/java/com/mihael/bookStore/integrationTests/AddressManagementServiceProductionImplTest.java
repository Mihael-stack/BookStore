package com.mihael.bookStore.integrationTests;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.exceptions.AddressNotFoundException;
import com.mihael.bookStore.services.address.AddressManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"/beans.xml", "/database-test.xml"})
@Transactional
class AddressManagementServiceProductionImplTest {
    @Autowired
    private AddressManagementService addressService;

    @Test
    void deleteAddress() throws AddressNotFoundException {
        Address address1 = addressService.findAddress(1L);
        Address address2 = addressService.findAddress(3L);
        Address address3 = addressService.findAddress(5L);

        addressService.deleteAddress(address1);
        addressService.deleteAddress(address2);
        addressService.deleteAddress(address3);

        assertThrows(AddressNotFoundException.class, () -> addressService.findAddress(1L));
        assertThrows(AddressNotFoundException.class, () -> addressService.findAddress(3L));
        assertThrows(AddressNotFoundException.class, () -> addressService.findAddress(5L));
    }

    @Test
    void findAddress() throws AddressNotFoundException {
        Address address1 = addressService.findAddress(1L);
        Address address2 = addressService.findAddress(3L);
        Address address3 = addressService.findAddress(5L);

        assertEquals("Address{street=1 BStreet, city=Belgrade, country=Serbia, " +
                "postalCode=ASS-22221, state=Serbia}",address1.toString());
        assertEquals("Address{street=105 Ave, city=Barcelona, country=Spain, " +
                "postalCode=2064, state=Spain}",address2.toString());
        assertEquals("Address{street=21 Other, city=Macedonia, country=Ohio, " +
                "postalCode=142, state=United States}",address3.toString());
    }

    @Test
    void findNonExistentAddress(){
        assertThrows(AddressNotFoundException.class, () -> addressService.findAddress(55L));
        assertThrows(AddressNotFoundException.class, () -> addressService.findAddress(66L));
        assertThrows(AddressNotFoundException.class, () -> addressService.findAddress(77L));
    }
}