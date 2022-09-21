package com.mihael.bookStore.integrationTests;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.exceptions.AddressNotFoundException;
import com.mihael.bookStore.exceptions.AuthorNotFoundException;
import com.mihael.bookStore.services.author.AuthorManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"/other-tiers.xml", "/database-test.xml"})
@Transactional
class AuthorManagementServiceProductionImplTest {

    @Autowired
    private AuthorManagementService authorService;

    Author databaseAuthor1 = new Author("Colleen Hoover", "Jane Hoover");
    Author databaseAuthor2 = new Author("Stephen King", "Stephen Queen");
    Author databaseAuthor3 = new Author("Jim Vandehei", "Josh Vandehei");

    @Test
    void removeAuthor() {
        this.databaseAuthor1.setId(8L);
        this.databaseAuthor2.setId(10L);
        this.databaseAuthor3.setId(12L);
        authorService.removeAuthor(databaseAuthor1);
        authorService.removeAuthor(databaseAuthor2);
        authorService.removeAuthor(databaseAuthor3);

        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorById(8L));
        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorById(10L));
        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorById(12L));
    }

    @Test
    void removeAuthorsAddress() throws AuthorNotFoundException, AddressNotFoundException {
        this.databaseAuthor1.setId(8L);
        this.databaseAuthor2.setId(10L);
        this.databaseAuthor3.setId(12L);
        this.authorService.removeAuthorsAddress(databaseAuthor1);
        this.authorService.removeAuthorsAddress(databaseAuthor2);
        this.authorService.removeAuthorsAddress(databaseAuthor3);
        assertNull(databaseAuthor1.getAddress());
        assertNull(databaseAuthor2.getAddress());
        assertNull(databaseAuthor3.getAddress());
    }

    @Test
    void findAuthorById() throws AuthorNotFoundException {
        this.databaseAuthor1.setId(8L);
        this.databaseAuthor2.setId(10L);
        this.databaseAuthor3.setId(12L);
        Author findAuthor1 = authorService.findAuthorById(8L);
        Author findAuthor2 = authorService.findAuthorById(10L);
        Author findAuthor3 = authorService.findAuthorById(12L);

        assertEquals(databaseAuthor1, findAuthor1);
        assertEquals(databaseAuthor2, findAuthor2);
        assertEquals(databaseAuthor3, findAuthor3);
    }

    @Test
    void findNonExistentAuthorById() {

        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorById(22L));
        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorById(33L));
        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorById(55L));

    }


    @Test
    void findAuthorByName() throws AuthorNotFoundException {
        this.databaseAuthor1.setId(8L);
        this.databaseAuthor2.setId(10L);
        this.databaseAuthor3.setId(12L);
        List<Author> findAuthor1 = authorService.findAuthorByName("Colleen Hoover");
        List<Author> findAuthor2 = authorService.findAuthorByName("Stephen King");
        List<Author> findAuthor3 = authorService.findAuthorByName("Jim Vandehei");

        assertEquals(1, findAuthor1.size());
        assertEquals(1, findAuthor2.size());
        assertEquals(1, findAuthor3.size());
    }

    @Test
    void findNonExistentAuthorByName(){
        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorByName("Something"));
        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorByName("garbage"));
        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorByName("Bad"));
    }

    @Test
    void findNonExistentAuthorByAlias() {
        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorByAlias("yay"));
        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorByAlias("Bad"));
        assertThrows(AuthorNotFoundException.class, () -> authorService.findAuthorByAlias("huehue"));
    }


}