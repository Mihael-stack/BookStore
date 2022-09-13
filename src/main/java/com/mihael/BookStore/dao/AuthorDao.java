package com.mihael.BookStore.dao;

import com.mihael.BookStore.entity.Author;

import java.util.List;

public interface AuthorDao {
    public void addAuthor(Author author);
    public Author findById(int id);
    public List<Author> findByName(String name);
    public void updateAuthor(Author newAuthor);
    public void deleteAuthor(Author removeAuthor);
}
