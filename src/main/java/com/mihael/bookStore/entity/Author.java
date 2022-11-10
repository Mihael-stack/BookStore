package com.mihael.bookStore.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty
    private String name;
    @NotEmpty
    private String about;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @NotEmpty
    private Set<Book> booksWritten;

    // Hibernate needs an empty constructor
    public Author(){}

    public Author(String name, String about){
        this.name = name;
        this.about = about;
        this.booksWritten = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Author(name"+name+",alias)";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setBooksWritten(Set<Book> booksWritten) {
        this.booksWritten.clear();
        this.booksWritten.addAll(booksWritten);
    }
    public void addBooksWritten(Book book){
        this.booksWritten.add(book);
    }

    public Set<Book> getBooksWrittenUnmodifiable() { // Unmodifiable set
        return Collections.unmodifiableSet(booksWritten);
    }

}
