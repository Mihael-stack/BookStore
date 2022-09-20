package com.mihael.bookStore.services.author;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.AddressNotFoundException;

import java.util.List;

public interface AuthorManagementService {
    void addNewAuthor(Author author);
    void addNewAuthorWithAddress(Author author, Address address);
    void removeAuthor(Author removeAuthor);
    void removeAuthorsAddress(Author author) throws AddressNotFoundException;
    Author findAuthorById(Long id);
    List<Author> findAuthorByName(String name);
    List<Author> findAuthorByAlias(String alias);
    void updateAuthor(Author newAuthor);
}
