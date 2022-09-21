package com.mihael.bookStore.dao.book;

import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.BookNotFoundException;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;

import java.util.List;

public interface BookDao {
    void addBook(Book book);
    Book findById(Long id) throws BookNotFoundException;
    Book findByISBN(String isbn) throws BookNotFoundException;
    void updateBook(Book newBook) throws ISBNIsInvalidException;
    void removeBook(Book removeBook) throws BookNotFoundException;
    List<Book> findByTitle(String title) throws BookNotFoundException;
}
