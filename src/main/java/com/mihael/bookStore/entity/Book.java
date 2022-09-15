package com.mihael.bookStore.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ISBN;
    private String title;

    @ManyToMany(mappedBy = "booksWritten", cascade = CascadeType.PERSIST)
    private Set<Author> authors;

    //Hibernate needs an empty constructor
    public Book(){}

    public Book(String ISBN, String title){
        this.ISBN = ISBN;
        this.title = title;
        this.authors = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }
    // TODO: FIX THIS ESCAPING REFERENCE
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
