package com.mihael.bookStore.services.bookAndAuthorManagementService;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.services.author.AuthorManagementService;
import com.mihael.bookStore.services.book.BookManagementService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
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
        this.authorService.addNewAuthor(author);
        this.bookService.addNewBook(book, author);
    }
    public void addAuthorWithBook(Author author, Book book) {
        this.bookService.addNewBook(book);
        this.authorService.addNewAuthor(author,book);
    }

    @Override
    public void addBookWithAuthors(Book book, Set<Author> authorSet) {

    }

    @Override
    public void addAuthorWithBooks(Author author, Set<Book> bookSet) {

    }
}
