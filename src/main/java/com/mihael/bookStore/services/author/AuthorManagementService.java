package com.mihael.bookStore.services.author;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.AuthorNotFoundException;

import java.util.List;

public interface AuthorManagementService {
    void addNewAuthor(Author author);
    void removeAuthor(Author removeAuthor);
    Author findAuthorById(Long id) throws AuthorNotFoundException;
    List<Author> findAuthorByName(String name) throws AuthorNotFoundException;
    void updateAuthor(Author newAuthor);
    void wroteABook(Author author, Book book);
}
