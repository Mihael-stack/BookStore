package com.mihael.bookStore.services.book;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.AuthorMissingFromBookException;
import com.mihael.bookStore.exceptions.BookNotFoundException;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;

import java.util.List;
import java.util.Set;

public interface BookManagementService {
    void addNewBook(Book book, Set<Author> authors) throws AuthorMissingFromBookException;
    void removeBook(Book removeBook) throws BookNotFoundException;
    Book findBookById(Long id) throws BookNotFoundException;
    Book findBookByISBN(String ISBN) throws BookNotFoundException;
    List<Book> findBookByTitle(String title) throws BookNotFoundException;
    void updateBook(Book newBook) throws ISBNIsInvalidException;
    List<Book> returnAllBooks() throws BookNotFoundException;
}
