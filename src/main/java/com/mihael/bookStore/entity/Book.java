package com.mihael.bookStore.entity;

import com.mihael.bookStore.exceptions.AuthorMissingFromBookException;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;
import com.mihael.bookStore.validator.ISBNValidator;
import com.mihael.bookStore.validator.annotations.ISBN;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @ISBN
    private String ISBN;
    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private String language;
    @NotNull
    private int pages;
    @NotNull
    @PastOrPresent
    private LocalDate published;
    private int amount;
    @ManyToMany(mappedBy = "booksWritten", cascade = CascadeType.PERSIST)
    @NotEmpty
    private Set<Author> authors;

    //Hibernate needs an empty constructor
    public Book(){}

    public Book(String ISBN, String title, String description, int pages,
                String language, LocalDate published, int amount) {
        this.ISBN = ISBNValidator.formattingISBN(ISBN);
        this.title = title;
        this.description = description;
        this.language = language;
        this.pages = pages;
        this.published = published;
        this.amount = amount;
        this.authors = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Book\t" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", pages=" + pages +
                ", published=" + published +
                ", amount=" + amount +
                ", authors=" + authors;
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

    public void setISBN(String ISBN) throws ISBNIsInvalidException {
        this.ISBN = ISBNValidator.checkISBN(ISBN);
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

    public void addAuthors(Set<Author> authors) throws AuthorMissingFromBookException {
        if(authors.isEmpty()){
            throw new AuthorMissingFromBookException("Author is a required field for a Book");
        }
        else {
            this.authors.addAll(authors);
        }
    }

    public Set<Author> getAuthorsUnmodifiable() { // Unmodifiable Set
        return Collections.unmodifiableSet(authors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && ISBN.equals(book.ISBN) && title.equals(book.title) && language.equals(book.language) && published.equals(book.published) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, title, language, pages, published, authors);
    }
}
