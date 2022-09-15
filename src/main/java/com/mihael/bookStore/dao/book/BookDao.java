package com.mihael.bookStore.dao.book;

import com.mihael.bookStore.entity.Book;

public interface BookDao {
    void addBook(Book book);
    Book findById(int id);
    Book findByISBN(String isbn);
    void updateBook(Book newBook);
    void removeBook(Book removeBook);
}
