package com.mihael.bookStore.integrationTests;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.services.customer.CustomerManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"/other-tiers.xml", "/database-test.xml"})
@Transactional
class CustomerManagementServiceProductionImplTest {
    @Autowired
    private CustomerManagementService customerService;


    @Test
    void findCustomerByEmail() {
        //arrange
        Customer customer1 = new Customer("Mike","O'Harra","MikeMail@mail.com");
        Address address1 = new Address("21 Street","London","England","AW-221","United Kingdom");
        Customer customer2 = new Customer("Luke","S'Dzinga","LukeMail@mail.com");
        Address address2 = new Address("21 Street","London","England","AW-221","United Kingdom");
        Customer customer3 = new Customer("Pan","LakyLuke","PanMail@mail.com");
        Address address3 = new Address("21 Street","London","England","AW-221","United Kingdom");
        //act
        customerService.addNewCustomerWithAddress(customer1, address1);
        customerService.addNewCustomerWithAddress(customer2, address2);
        customerService.addNewCustomerWithAddress(customer3, address3);
        Customer checking1 = customerService.findCustomerByEmail("MikeMail@mail.com");
        Customer checking2 = customerService.findCustomerByEmail("LukeMail@mail.com");
        Customer checking3 = customerService.findCustomerByEmail("PanMail@mail.com");
        //assert
        assertEquals("O'Harra", checking1.getLastName());
        assertEquals("S'Dzinga", checking2.getLastName());
        assertEquals("LakyLuke", checking3.getLastName());

    }

//    @Test
//    void updateCustomer() {
//
//    }

//    @Test
//    void removeCustomer() {
//        fail();
//    }

}