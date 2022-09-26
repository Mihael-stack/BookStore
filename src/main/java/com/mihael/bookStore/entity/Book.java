package com.mihael.bookStore.entity;

import com.mihael.bookStore.exceptions.ISBNIsInvalidException;
import com.mihael.bookStore.validator.ISBNValidator;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ISBN;
    private String title;

    @ManyToMany(mappedBy = "booksWritten", cascade = CascadeType.PERSIST)
    private Set<Author> authors;

    //Hibernate needs an empty constructor
    public Book(){}

    public Book(String ISBN, String title) throws ISBNIsInvalidException {
        this.ISBN = ISBNValidator.checkISBN(ISBN);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public Set<Author> getAuthorsUnmodifiable() { // Unmodifiable Set
        return Collections.unmodifiableSet(authors);
    }

    public void setISBN(String ISBN) throws ISBNIsInvalidException {
        this.ISBN = ISBNValidator.checkISBN(ISBN);
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setAuthors(Set<Author> authors) {
        authors.clear();
        this.authors = authors;
    }
    public void addAuthor(Author author){
        this.authors.add(author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ISBN.equals(book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }
}
