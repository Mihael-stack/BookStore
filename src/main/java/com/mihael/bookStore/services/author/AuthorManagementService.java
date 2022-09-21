package com.mihael.bookStore.services.author;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.AddressNotFoundException;
import com.mihael.bookStore.exceptions.AuthorNotFoundException;

import java.util.List;

public interface AuthorManagementService {
    void addNewAuthor(Author author);
    void addNewAuthor(Author author, Book book);
    void addNewAuthorWithAddress(Author author, Address address);
    void removeAuthor(Author removeAuthor);
    void removeAuthorsAddress(Author author) throws AddressNotFoundException, AuthorNotFoundException;
    Author findAuthorById(Long id) throws AuthorNotFoundException;
    List<Author> findAuthorByName(String name) throws AuthorNotFoundException;
    List<Author> findAuthorByAlias(String alias) throws AuthorNotFoundException;
    void updateAuthor(Author newAuthor);
}
