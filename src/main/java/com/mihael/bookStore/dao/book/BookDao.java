package com.mihael.bookStore.dao.book;

import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;

import java.util.List;

public interface BookDao {
    void addBook(Book book);
    Book findById(Long id);
    Book findByISBN(String isbn);
    void updateBook(Book newBook) throws ISBNIsInvalidException;
    void removeBook(Book removeBook);
    List<Book> findByTitle(String title);
}
