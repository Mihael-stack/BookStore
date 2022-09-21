package com.mihael.bookStore.integrationTests;

import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.BookNotFoundException;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;
import com.mihael.bookStore.services.book.BookManagementService;
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
class BookManagementServiceProductionImplTest {

    @Autowired
    private BookManagementService bookService;

    Book databaseBook1 = new Book("1638930163","The Empress: A Novel");
    Book databaseBook2 = new Book("0804176604","Devotion: An Epic Story of Heroism, Friendship, and Sacrifice");
    Book databaseBook3 = new Book("978-1524796303","Fire & Blood: 300 Years Before A Game of Thrones");
    Book databaseBook4 = new Book("978-0399226908","The Very Hungry Caterpillar");
    Book databaseBook5 = new Book("0805047905","rown Bear, Brown Bear, What Do You See?");

    BookManagementServiceProductionImplTest() throws ISBNIsInvalidException {

    }

    @Test
    void removeBook() throws BookNotFoundException {
        this.databaseBook1.setId(19L);
        this.databaseBook2.setId(20L);
        this.databaseBook3.setId(21L);
        this.databaseBook4.setId(22L);
        this.databaseBook5.setId(23L);

        bookService.removeBook(databaseBook1);
        bookService.removeBook(databaseBook2);
        bookService.removeBook(databaseBook3);
        bookService.removeBook(databaseBook4);
        bookService.removeBook(databaseBook5);

        assertThrows(BookNotFoundException.class, () -> bookService.findBookById(19L));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookById(20L));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookById(21L));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookById(22L));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookById(23L));
    }

    @Test
    void findNonExistentBookById() {
        assertThrows(BookNotFoundException.class, () -> bookService.findBookById(100L));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookById(200L));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookById(250L));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookById(110L));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookById(50L));

    }

    @Test
    void findNonExistentBookByISBN() {
        assertThrows(BookNotFoundException.class, () -> bookService.findBookByISBN("2131321"));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookByISBN("3213213"));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookByISBN("123213"));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookByISBN("12321"));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookByISBN("321321"));
    }

    @Test
    void findNonExistentBookByTitle() {
        assertThrows(BookNotFoundException.class, () -> bookService.findBookByTitle("2131321"));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookByTitle("3213213"));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookByTitle("123213"));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookByTitle("12321"));
        assertThrows(BookNotFoundException.class, () -> bookService.findBookByTitle("321321"));
    }
}