package com.mihael.bookStore.representations;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "book")
public class BookRepresentation {

    private Long id;
    private String ISBN;
    private String title;
    private Set<Author> authors;

    public BookRepresentation(){}
    public BookRepresentation(Book book){
        this.id = book.getId();
        this.ISBN = book.getISBN();
        this.title = book.getTitle();
        this.authors = new HashSet<>();
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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
