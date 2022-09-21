package com.mihael.bookStore.integrationTests;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;
import com.mihael.bookStore.services.book.BookManagementService;
import com.mihael.bookStore.services.book.BookManagementServiceProductionImpl;
import com.mihael.bookStore.services.bookAndAuthorManagementService.BookAndAuthorManagementService;
import com.mihael.bookStore.services.bookAndAuthorManagementService.BookAndAuthorManagementServiceProductionImpl;
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
class BookAndAuthorManagementServiceProductionImplTest {
    @Autowired
    BookAndAuthorManagementService bookAndAuthorManagementService;

    @Test
    void addBookWithAuthor() throws ISBNIsInvalidException {
        Book book1 = new Book("1637970137","Fly High");
        Book book2 = new Book("0804176604","Devotion: An Epic Story of Heroism, Friendship, and Sacrifice");
        Book book3 = new Book("978-1524796303","Fire & Blood: 300 Years Before A Game of Thrones");
        Author author1 = new Author("Janet K. Johnson", "Jennet");
        Author author2 = new Author("Michelle Medlock Adams", "Medlock");

        bookAndAuthorManagementService.addAuthorWithBook(author1, book1);
        bookAndAuthorManagementService.addAuthorWithBook(author1, book3);
        bookAndAuthorManagementService.addBookWithAuthor(book2,author2);
        bookAndAuthorManagementService.addBookWithAuthor(book1,author2);
    }

    @Test
    void addAuthorWithBook() {
    }
}