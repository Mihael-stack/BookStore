package com.mihael.bookStore.services.bookAndAuthorManagementService;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;

import java.util.Set;

public interface BookAndAuthorManagementService {
    void addBookWithAuthor(Book book,Author author);
    void addAuthorWithBook(Author author, Book book);
    void addBookWithAuthors(Book book, Set<Author> authorSet);
    void addAuthorWithBooks(Author author, Set<Book> bookSet);

}
