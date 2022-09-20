package com.mihael.bookStore.services.book;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;

import java.util.List;

public interface BookManagementService {
    void addNewBook(Book book);
    void removeBook(Book removeBook);
    Book findBookByISBN(String ISBN);
    List<Book> findBookByTitle(String title);
    void updateBook(Book newBook) throws ISBNIsInvalidException;
}
