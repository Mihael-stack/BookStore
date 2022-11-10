package com.mihael.bookStore.representations;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.validator.ISBNValidator;
import com.mihael.bookStore.validator.annotations.ISBN;
import org.springframework.hateoas.RepresentationModel;


import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.Set;

@XmlRootElement(name = "book")
public class BookRepresentation extends RepresentationModel {

    private Long id;
    @ISBN
    private String ISBN;

    private String title;

    private String description;

    private String language;

    private int pages;

    private LocalDate published;

    private int amount;

    private Set<Author> authors;

    public BookRepresentation(){}
    public BookRepresentation(String ISBN, String title, String description, int pages,
                              String language, LocalDate published, int amount, Set<Author> authors) {
        this.ISBN = ISBNValidator.formattingISBN(ISBN);
        this.title = title;
        this.description = description;
        this.language = language;
        this.pages = pages;
        this.published = published;
        this.amount = amount;
        this.authors = authors;
    }
    public BookRepresentation(Book book){
        this.ISBN = book.getISBN();
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.language = book.getLanguage();
        this.pages = book.getPages();
        this.published = book.getPublished();
        this.amount = book.getAmount();
        this.authors = book.getAuthors();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
