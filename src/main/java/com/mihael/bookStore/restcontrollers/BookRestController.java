package com.mihael.bookStore.restcontrollers;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.AuthorMissingFromBookException;
import com.mihael.bookStore.exceptions.BookNotFoundException;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;
import com.mihael.bookStore.representations.BookCollectionRepresentation;
import com.mihael.bookStore.representations.BookRepresentation;
import com.mihael.bookStore.representations.ClientErrorInformation;
import com.mihael.bookStore.services.book.BookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Set;

@RestController
public class BookRestController {
    private final BookManagementService bookService;

    @Autowired
    public BookRestController(BookManagementService bookService){
        this.bookService = bookService;
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ClientErrorInformation> rulesForBookNotFoundException(Exception e){
        ClientErrorInformation error = new ClientErrorInformation(e.toString());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({AuthorMissingFromBookException.class, ISBNIsInvalidException.class})
    public ResponseEntity<ClientErrorInformation> rulesBadRequestException(Exception e){
        ClientErrorInformation error = new ClientErrorInformation(e.toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("book/{id}")
    public BookRepresentation findBookById(@PathVariable Long id) throws BookNotFoundException {
        BookRepresentation book = new BookRepresentation(bookService.findBookById(id));
        Link link = linkTo(methodOn(BookRestController.class).findBookById(book.getId())).withSelfRel();
        book.add(link);
        return book;
    }

    @GetMapping("/books")
    public BookCollectionRepresentation returnAllBooks() throws BookNotFoundException {
        BookCollectionRepresentation books = new BookCollectionRepresentation(bookService.returnAllBooks());
        for(BookRepresentation book : books.getBooks()) {
            Link link = linkTo(methodOn(BookRestController.class).findBookById(book.getId())).withSelfRel();
            book.add(link);
        }
        return books;
    }
    // TODO: createBook needs improving in service layer.
    @PostMapping("/books")
    public BookRepresentation createNewBook(@RequestBody @Valid Book book, @RequestBody @Valid Set<Author> author) throws BookNotFoundException, AuthorMissingFromBookException {
        this.bookService.addNewBook(book, author);
        BookRepresentation findBook  = new BookRepresentation(this.bookService.findBookByISBN(book.getISBN()));
        Link link = linkTo(methodOn(BookRestController.class).findBookById(findBook.getId())).withSelfRel();
        findBook.add(link);
        return findBook;
    }
    @DeleteMapping("/book/{id}")
    public Link deleteBook(@PathVariable Long id) throws BookNotFoundException {
        this.bookService.removeBook(this.bookService.findBookById(id));
        return linkTo(methodOn(BookRestController.class).returnAllBooks()).withRel("books");
    }
    @PutMapping("/book/{id}")
    public BookRepresentation updateBook(@PathVariable Long id) throws BookNotFoundException, ISBNIsInvalidException {
        this.bookService.updateBook(this.bookService.findBookById(id));
        BookRepresentation book = new BookRepresentation(this.bookService.findBookById(id));
        Link link = linkTo(methodOn(BookRestController.class).findBookById(id)).withSelfRel();
        book.add(link);
        return book;
    }
}
