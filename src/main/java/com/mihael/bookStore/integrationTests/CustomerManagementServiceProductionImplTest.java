package com.mihael.bookStore.integrationTests;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;
import com.mihael.bookStore.services.customer.CustomerManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    void findCustomerByEmail() throws CustomerNotFoundException, CustomerAlreadyExistWithProvidedEmailException {
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

    /* Hibernate/JPA persists the method at the end of the transaction, which means the throw/catch exception won't be
    * caught or thrown until then. Because of that it bypasses this test and some mechanisms of my code, but it still catches and
    * deals with rollbacks. Tested in client.
    @Test
    void testAddingNewCustomerWithExisingEmail() {
        Customer customer1 = new Customer("Ben","Ten","benTen@mail.com");
        Address address1 = new Address("1 BStreet","Belgrade","Serbia","ASS-22221","Serbia");
        Customer customer2 = new Customer("Namda","Mamba","namdaMamba@mail.com");
        Address address2 = new Address("105 Ave","Barcelona","Spain","2064","Spain");
        Customer customer3 = new Customer("Steve","Bobber","steveBobber@mail.com");
        Address address3 = new Address("21 Other","Macedonia","Ohio","142","United States");


        CustomerAlreadyExistWithProvidedEmailException exception1 = assertThrows(CustomerAlreadyExistWithProvidedEmailException.class, () -> {
            customerService.addNewCustomerWithAddress(customer1,address1);
        });
        assertThrows(DataIntegrityViolationException.class, () -> {
            customerService.addNewCustomerWithAddress(customer2,address2);
        });        assertThrows(DataIntegrityViolationException.class, () -> {
            customerService.addNewCustomerWithAddress(customer3, address3);
        });

        assertTrue(exception1.getMessage().contains("The Customer already exist with provided email."));
    }
    * */

    @Test
    void updateCustomerWithAddress() throws CustomerNotFoundException {


        Customer newCustomer1 = new Customer("Mihael","Stoilkovski","mihael.stoilkovski@mail.com");
        Address newAddress1 = new Address("2B Street","Skopje","North Macedonia","1000","North Macedonia");
        Customer newCustomer2 = new Customer("Raven","Black","raven.black@mail.com");
        Address newAddress2 = new Address("16th Avenue","Bucharest","Romania","10991","Romania");
        Customer newCustomer3 = new Customer("Sam","Carter","stargate.command@mail.com");
        Address newAddress3 = new Address("cheyenne mountain","Colorado Springs","Colorado","12121212","United States");

        // TODO: Fix this - Find the id's by other means, because id's will change when you delete database and start over
        newCustomer1.setId(2);
        newCustomer2.setId(4);
        newCustomer3.setId(6);
        newAddress1.setId(1);
        newAddress2.setId(3);
        newAddress3.setId(5);

        customerService.updateCustomerWithAddress(newCustomer1,newAddress1);
        customerService.updateCustomerWithAddress(newCustomer2,newAddress2);
        customerService.updateCustomerWithAddress(newCustomer3,newAddress3);

        Customer findCustomer1 = customerService.findCustomerById(2);
        Customer findCustomer2 = customerService.findCustomerById(4);
        Customer findCustomer3 = customerService.findCustomerById(6);

        assertEquals("Customer{firstName=Mihael, lastName=Stoilkovski, " +
                "emailAddress=mihael.stoilkovski@mail.com, address=Address{street=2B Street, " +
                "city=Skopje, country=North Macedonia, postalCode=1000, state=North Macedonia}}",findCustomer1.toString());

        assertEquals("Customer{firstName=Raven, lastName=Black, " +
                "emailAddress=raven.black@mail.com, address=Address{street=16th Avenue, " +
                "city=Bucharest, country=Romania, postalCode=10991, state=Romania}}",findCustomer2.toString());

        assertEquals("Customer{firstName=Sam, lastName=Carter, " +
                "emailAddress=stargate.command@mail.com, address=Address{street=cheyenne mountain, " +
                "city=Colorado Springs, country=Colorado, postalCode=12121212, state=United States}}",findCustomer3.toString());

    }
    @Test
    void testFindingNonExistentCustomerById() throws CustomerNotFoundException {
        assertThrows(CustomerNotFoundException.class, () -> {
            Customer findCustomer1 = customerService.findCustomerById(55);
        });
        assertThrows(CustomerNotFoundException.class, () -> {
            Customer findCustomer2 = customerService.findCustomerById(66);
        });        assertThrows(CustomerNotFoundException.class, () -> {
            Customer findCustomer3 = customerService.findCustomerById(77);
        });

    }
    @Test
    void testFindingNonExistentCustomerByEmail() throws CustomerNotFoundException {
        assertThrows(CustomerNotFoundException.class, () -> {
            Customer findCustomer1 = customerService.findCustomerByEmail("garbage email");
        });
        assertThrows(CustomerNotFoundException.class, () -> {
            Customer findCustomer2 = customerService.findCustomerByEmail("non-existent email");
        });        assertThrows(CustomerNotFoundException.class, () -> {
            Customer findCustomer3 = customerService.findCustomerByEmail("been coding for too long... email");
        });

    }

//    @Test
//    void removeCustomer() {
//        fail();
//    }

}