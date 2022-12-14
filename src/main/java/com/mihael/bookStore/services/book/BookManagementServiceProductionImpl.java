package com.mihael.bookStore.services.book;

import com.mihael.bookStore.dao.book.BookDao;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.AuthorMissingFromBookException;
import com.mihael.bookStore.exceptions.BookNotFoundException;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
public class BookManagementServiceProductionImpl implements BookManagementService{

    private final BookDao dao;

    public BookManagementServiceProductionImpl(BookDao dao){
        this.dao = dao;
    }

    // TODO: creating new Book needs improvement. And second method for newBook but with existing Authors.
    @Override
    public void addNewBook(Book book, Set<Author> authors) throws AuthorMissingFromBookException {
        book.addAuthors(authors);
        for(Author author : authors){
            author.addBooksWritten(book);
        }
        this.dao.addBook(book);
    }

    @Override
    public void removeBook(Book removeBook) throws BookNotFoundException {
        this.dao.removeBook(removeBook);
    }

    @Override
    public Book findBookById(Long id) throws BookNotFoundException {
        return this.dao.findById(id);
    }

    @Override
    public Book findBookByISBN(String ISBN) throws BookNotFoundException {
        return this.dao.findByISBN(ISBN);
    }

    @Override
    public List<Book> findBookByTitle(String title) throws BookNotFoundException {
        return this.dao.findByTitle(title);
    }

    @Override
    public void updateBook(Book newBook) throws ISBNIsInvalidException {
        this.dao.updateBook(newBook);
    }

    @Override
    public List<Book> returnAllBooks() throws BookNotFoundException{
       return this.dao.returnAllBooks();
    }
}
