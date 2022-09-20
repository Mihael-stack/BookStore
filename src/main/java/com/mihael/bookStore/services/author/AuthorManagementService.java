package com.mihael.bookStore.services.author;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;

public interface AuthorManagementService {
    void addNewAuthor(Author author);
    void addBookToAAuthor(Book book);
    void removeAuthor(Author removeAuthor);
    Author findAuthorById(Long id);
    Author findAuthorByName(String name);
    Author findAuthorByAlias(String alias);
    void updateAuthor(Author newAuthor);
}
