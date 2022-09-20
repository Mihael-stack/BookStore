package com.mihael.bookStore.services.bookAndAuthorManagementService;

import com.mihael.bookStore.services.author.AuthorManagementService;
import com.mihael.bookStore.services.book.BookManagementService;

public class BookAndAuthorManagementServiceProductionImpl implements BookAndAuthorManagementService{

    private final BookManagementService bookService;
    private final AuthorManagementService authorService;

    public BookAndAuthorManagementServiceProductionImpl(BookManagementService bookService, AuthorManagementService authorService){
        this.bookService = bookService;
        this.authorService = authorService;
    }
}
