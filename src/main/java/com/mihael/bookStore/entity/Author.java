package com.mihael.bookStore.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String alias;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Book> booksWritten;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Address address;

    // Hibernate needs an empty constructor
    public Author(){}

    public Author(String name, String alias){
        this.name = name;
        this.alias = alias;
        this.booksWritten = new HashSet<>();
        this.address = null;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setBooksWritten(Set<Book> booksWritten) {
        this.booksWritten.clear();
        this.booksWritten.addAll(booksWritten);
    }
    public void addBooksWritten(Book book){
        this.booksWritten.add(book);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() { // Use this method only if you are going to change values
        return address;
    }

    public AddressReadOnly getAddressReadOnly(){ // Use this if you are not going ot change values
        return address;
    }

    public Set<Book> getBooksWrittenUnmodifiable() { // Unmodifiable set
        return Collections.unmodifiableSet(booksWritten);
    }


}
