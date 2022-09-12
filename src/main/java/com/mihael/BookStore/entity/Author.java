package com.mihael.BookStore.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String alias;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Book> booksWritten;

    @ManyToOne
    private Address address;

    // Hibernate needs an empty constructor
    public Author(){}

    public Author(String name, String alias){
        this.name = name;
        this.alias = alias;
        this.booksWritten = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
