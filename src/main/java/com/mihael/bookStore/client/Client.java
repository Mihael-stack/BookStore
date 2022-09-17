package com.mihael.bookStore.client;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.CustomerNotFoundException;
import com.mihael.bookStore.services.customer.CustomerManagementService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
        CustomerManagementService customerService = container.getBean("customerManagementService",CustomerManagementService.class);
        Customer customer1 = new Customer("Ben","Ten","benTen@mail.com");
        Address address1 = new Address("1 BStreet","Belgrade","Serbia","ASS-22221","Serbia");

        try {
            customerService.addNewCustomerWithAddress(customer1,address1);
        }
        catch (org.springframework.dao.DataIntegrityViolationException e){
            System.out.println(e);
        } // The Exception is not being caught because the way hibernate works, it flags the persist method when called
        // but it does not execute it, it only does when the transaction commit is being done, by then it bypassed all my
        // Exception handling and then crashes. It only catches the exception outside of the service method, the client.


    }

    public void creatingCustomersWithAddress() throws CustomerNotFoundException, CustomerAlreadyExistWithProvidedEmailException {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
        CustomerManagementService customerService = container.getBean("customerManagementService",CustomerManagementService.class);

        Customer customer1 = new Customer("Ben","Ten","benTen@mail.com");
        Address address1 = new Address("1 BStreet","Belgrade","Serbia","ASS-22221","Serbia");
        Customer customer2 = new Customer("Namda","Mamba","namdaMamba@mail.com");
        Address address2 = new Address("105 Ave","Barcelona","Spain","2064","Spain");
        Customer customer3 = new Customer("Steve","Bobber","steveBobber@mail.com");
        Address address3 = new Address("21 Other","Macedonia","Ohio","142","United States");

        customerService.addNewCustomerWithAddress(customer1,address1);
        customerService.addNewCustomerWithAddress(customer2,address2);
        customerService.addNewCustomerWithAddress(customer3, address3);
        try {
            Customer findCustomer1 = customerService.findCustomerByEmail("benTen@mail.com");
            Customer findCustomer2 = customerService.findCustomerByEmail("namdaMamba@mail.com");
            Customer findCustomer3 = customerService.findCustomerByEmail("steveBobber@mail.com");
            System.out.println(findCustomer1.toString());
            System.out.println(findCustomer2.toString());
            System.out.println(findCustomer3.toString());
        }
        catch (CustomerNotFoundException e){
            System.out.println(e);
        }



    }
}
