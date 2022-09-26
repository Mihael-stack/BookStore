package com.mihael.bookStore.client;

import com.mihael.bookStore.dao.author.AuthorDao;
import com.mihael.bookStore.dao.book.BookDao;
import com.mihael.bookStore.dao.book.BookDaoJPAProduction;
import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
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
        //TODO: Before Fixing BookDao and BookManagementService, Create REST API For Customers and Angular frontEnd

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

        authorService.addNewAuthorWithAddress(author1,address1);
        authorService.addNewAuthorWithAddress(author2,address2);
        authorService.addNewAuthorWithAddress(author3,address3);


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

    public static void creatingBooks() throws ISBNIsInvalidException {
        //TODO:: Fix BookDao and BookManagementService
        BookDao bookService = container.getBean("bookDao", BookDaoJPAProduction.class);
        Book book1 = new Book("1638930163","The Empress: A Novel");
        Book book2 = new Book("0804176604","Devotion: An Epic Story of Heroism, Friendship, and Sacrifice");
        Book book3 = new Book("978-1524796303","Fire & Blood: 300 Years Before A Game of Thrones");
        Book book4 = new Book("978-0399226908","The Very Hungry Caterpillar");
        Book book5 = new Book("0805047905","rown Bear, Brown Bear, What Do You See?");

        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
        bookService.addBook(book4);
        bookService.addBook(book5);

    }
//    public static void creatingBooksWithAuthors() throws ISBNIsInvalidException {
//        BookAndAuthorManagementService bookAndAuthorManagementService = container.getBean("bookAndAuthorManagementService",BookAndAuthorManagementServiceProductionImpl.class);
//
//        Book book1 = new Book("1637970137","Fly High");
//        Book book2 = new Book("0804176604","Devotion: An Epic Story of Heroism, Friendship, and Sacrifice");
//        Book book3 = new Book("978-1524796303","Fire & Blood: 300 Years Before A Game of Thrones");
//        Author author1 = new Author("Janet K. Johnson", "Jennet");
//        Author author2 = new Author("Michelle Medlock Adams", "Medlock");
//
//        bookAndAuthorManagementService.addAuthorWithBook(author1, book1);
//        bookAndAuthorManagementService.addAuthorWithBook(author1, book3);
//        bookAndAuthorManagementService.addBookWithAuthor(book2,author2);
//        bookAndAuthorManagementService.addBookWithAuthor(book1,author2);
//    }
}
