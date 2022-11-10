package com.mihael.bookStore.dao.author;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.AuthorNotFoundException;

import java.util.List;

public interface AuthorDao {
    void addAuthor(Author author);
    Author findById(Long id) throws AuthorNotFoundException;
    List<Author> findByName(String name) throws AuthorNotFoundException;
    void updateAuthor(Author newAuthor);
    void deleteAuthor(Author removeAuthor);
    void updateBookList(Author author, Book book);
}
