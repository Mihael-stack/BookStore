package com.mihael.bookStore.dao.author;

import com.mihael.bookStore.entity.Author;

import java.util.List;

public interface AuthorDao {
    void addAuthor(Author author);
    Author findById(Long id);
    List<Author> findByName(String name);
    void updateAuthor(Author newAuthor);
    void deleteAuthor(Author removeAuthor);

    List<Author> findByAlias(String alias);
}
