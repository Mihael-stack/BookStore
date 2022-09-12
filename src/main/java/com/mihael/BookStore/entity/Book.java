package com.mihael.BookStore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ISBN;
    private String title;

    @ManyToMany(mappedBy = "booksWritten")
    private Set<Author> authors;

    //Hibernate needs an empty constructor
    public Book(){}

    public Book(String ISBN, String title){
        this.ISBN = ISBN;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
