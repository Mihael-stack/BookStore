package com.mihael.BookStore.entity;

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
}
