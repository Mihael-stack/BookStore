package com.mihael.BookStore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String alias;
    @ManyToMany
    private Set<Book> booksWritten;

    @ManyToOne
    private Address address;

    // Hibernate needs an empty constructor
    public Author(){}

    public Author(String name, String alias){
        this.name = name;
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
