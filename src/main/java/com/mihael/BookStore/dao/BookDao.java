package com.mihael.BookStore.dao;

import com.mihael.BookStore.entity.Book;

public interface BookDao {
    public void addBook(Book book);
    public Book findById(int id);
    public Book findByISBN(String isbn);
    public void updateBook(Book newBook);
    public void removeBook(Book removeBook);
}
