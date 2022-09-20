package com.mihael.bookStore.services.book;

import com.mihael.bookStore.dao.book.BookDao;

import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;

import java.util.List;

public class BookManagementServiceProductionImpl implements BookManagementService{

    private final BookDao dao;

    public BookManagementServiceProductionImpl(BookDao dao){
        this.dao = dao;
    }

    @Override
    public void addNewBook(Book book) {
        this.dao.addBook(book);
    }

    @Override
    public void removeBook(Book removeBook) {
        this.dao.removeBook(removeBook);
    }

    @Override
    public Book findBookByISBN(String ISBN) {
        return this.dao.findByISBN(ISBN);
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        return this.dao.findByTitle(title);
    }

    @Override
    public void updateBook(Book newBook) throws ISBNIsInvalidException {
        this.dao.updateBook(newBook);
    }
}
