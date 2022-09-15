package com.mihael.bookStore.client;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.services.customer.CustomerManagementService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
        CustomerManagementService customerService = container.getBean("customerManagementService",CustomerManagementService.class);

        Customer customer = new Customer("Mike","O'Harra","somethingMail@mail.com");
        Address address = new Address("21 Street","London","England","AW-221","United Kingdom");
        customerService.addNewCustomerWithAddress(customer,address);
        Customer checking = customerService.findCustomerByEmail("somethingMail@mail.com");
        System.out.println(checking);
    }
}
