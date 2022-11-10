package com.mihael.bookStore.services.author;

import com.mihael.bookStore.dao.author.AuthorDao;
import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.AuthorNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class AuthorManagementServiceProductionImpl implements AuthorManagementService{

    private final AuthorDao dao;
    public AuthorManagementServiceProductionImpl(AuthorDao dao){
        this.dao = dao;
    }

    @Override
    public void addNewAuthor(Author author) {
        this.dao.addAuthor(author);
    }

    @Override
    public void removeAuthor(Author removeAuthor) {
        this.dao.deleteAuthor(removeAuthor);
    }

    @Override
    public Author findAuthorById(Long id) throws AuthorNotFoundException {
        return this.dao.findById(id);
    }

    @Override
    public List<Author> findAuthorByName(String name) throws AuthorNotFoundException {
        return this.dao.findByName(name);
    }
    @Override
    public void updateAuthor(Author newAuthor) {
        this.dao.updateAuthor(newAuthor);
    }

    @Override
    public void wroteABook(Author author, Book book) {
        this.dao.updateBookList(author, book);
    }

}
