package com.mihael.bookStore.services.bookAndAuthorManagementService;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;

public interface BookAndAuthorManagementService {
    void addBookWithAuthor(Book book, Author author);
    void addBookWithAuthor(Book book, Author author, Address address);
    void addAuthorWithBook(Author author, Book book);
    void addAuthorWithBook(Author author, Book book, Address address);
}
