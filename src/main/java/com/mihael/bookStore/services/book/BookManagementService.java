package com.mihael.bookStore.services.book;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;

public interface BookManagementService {
    void addNewBook(Book book);
    void addAuthorToABook(Author author);
    void removeBook(Book removeBook);
    Book findBookByISBN(String ISBN);
    Book findBookByTitle(String title);
    void updateBook(Book newBook);
}
