package com.mihael.bookStore.restcontrollers;

import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.BookNotFoundException;
import com.mihael.bookStore.representations.BookCollectionRepresentation;
import com.mihael.bookStore.representations.BookRepresentation;
import com.mihael.bookStore.representations.CustomerCollectionRepresentation;
import com.mihael.bookStore.services.book.BookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {
    private final BookManagementService bookService;

    @Autowired
    public BookRestController(BookManagementService bookService){
        this.bookService = bookService;
    }

    @GetMapping("books")
    public BookCollectionRepresentation returnAllBooks() throws BookNotFoundException {
        return new BookCollectionRepresentation(bookService.returnAllBooks());
    }

    @PostMapping("books")
    public BookRepresentation createNewBook(@RequestBody Book book) throws BookNotFoundException {
        this.bookService.addNewBook(book);
        Book findBook = this.bookService.findBookByISBN(book.getISBN());
        return new BookRepresentation(findBook);
    }
}
