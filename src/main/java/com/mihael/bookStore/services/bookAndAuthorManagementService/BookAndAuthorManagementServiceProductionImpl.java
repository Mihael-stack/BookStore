package com.mihael.bookStore.services.bookAndAuthorManagementService;

import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.services.author.AuthorManagementService;
import com.mihael.bookStore.services.book.BookManagementService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class BookAndAuthorManagementServiceProductionImpl implements BookAndAuthorManagementService{

    private final BookManagementService bookService;
    private final AuthorManagementService authorService;

    public BookAndAuthorManagementServiceProductionImpl(BookManagementService bookService, AuthorManagementService authorService){
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void addBookWithAuthor(Book book, Author author) {

    }

    @Override
    public void addBookWithAuthor(Book book, Author author, Address address) {

    }

    @Override
    public void addAuthorWithBook(Author author, Book book) {

    }

    @Override
    public void addAuthorWithBook(Author author, Book book, Address address) {

    }
}
