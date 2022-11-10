package com.mihael.bookStore.client;

import com.mihael.bookStore.dao.author.AuthorDao;
import com.mihael.bookStore.dao.book.BookDao;
import com.mihael.bookStore.dao.book.BookDaoJPAProduction;
import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Author;

import com.mihael.bookStore.entity.Customer;
import com.mihael.bookStore.exceptions.CustomerAlreadyExistWithProvidedEmailException;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;
import com.mihael.bookStore.services.author.AuthorManagementService;

import com.mihael.bookStore.services.customer.CustomerManagementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");;

    static Log logger = LogFactory.getLog(Client.class);
    public static void main(String[] args) throws ISBNIsInvalidException, CustomerAlreadyExistWithProvidedEmailException {
        BookDao bookService = container.getBean("bookDao", BookDaoJPAProduction.class);

    }

    public static void creatingCustomersWithAddress() throws CustomerAlreadyExistWithProvidedEmailException {

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

    }
    public static void creatingAuthors(){
        AuthorManagementService authorService = container.getBean("authorManagementService", AuthorManagementService.class);
        Author author1 = new Author("Colleen Hoover", "Jane Hoover");
        Author author2 = new Author("Stephen King", "Stephen Queen");
        Author author3 = new Author("Jim Vandehei", "Josh Vandehei");
        Address address1 = new Address("Partizanski Odredi","Bitola","North Macedonia",
                "1150","North Macedonia");
        Address address2 = new Address("21 Heroes St.","Kyiv","Ukraine","4200","Ukraine");
        Address address3 = new Address("16 DownTown","London","England","5588","United Kingdom");


    }
    public static void creatingAuthorsAuthorDao(){
        AuthorDao authorService = container.getBean("authorDao", AuthorDao.class);
        Author author1 = new Author("Colleen Hoover", "Jane Hoover");
        Author author2 = new Author("Stephen King", "Stephen Queen");
        Author author3 = new Author("Jim Vandehei", "Josh Vandehei");

        authorService.addAuthor(author1);
        authorService.addAuthor(author2);
        authorService.addAuthor(author3);


    }
}
