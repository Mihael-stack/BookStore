package com.mihael.bookStore.integrationTests;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"/beans.xml", "/database-test.xml"})
@Transactional
class BookAndAuthorManagementServiceProductionImplTest {


    Book book1 = new Book("1637970137","Fly High");
    Book book2 = new Book("0804176604","Devotion: An Epic Story of Heroism, Friendship, and Sacrifice");
    Book book3 = new Book("978-1524796303","Fire & Blood: 300 Years Before A Game of Thrones");
    Author author1 = new Author("Janet K. Johnson", "Jennet");
    Author author2 = new Author("Michelle Medlock Adams", "Medlock");

    BookAndAuthorManagementServiceProductionImplTest() throws ISBNIsInvalidException {
    }


    @Test
    void addBookWithAuthor() throws ISBNIsInvalidException {

    }

    @Test
    void addAuthorWithBook() {
    }
}