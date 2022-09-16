package com.mihael.bookStore.dao.book;

import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class BookDaoJPAProduction implements BookDao{
    @PersistenceContext
    private EntityManager em;


    @Override
    public void addBook(Book book) {
        this.em.persist(book);
    }

    @Override
    public Book findById(int id) {
        return this.em.find(Book.class,id);
    }

    @Override
    public Book findByISBN(String isbn) {
        return (Book)this.em.createQuery("SELECT book FROM Book as book WHERE book.ISBN=:isbn")
                .setParameter("isbn",isbn).getSingleResult();
    }

    @Override
    public void updateBook(Book newBook) throws ISBNIsInvalidException {
        Book oldBook = this.em.find(Book.class, newBook.getId());
        oldBook.setISBN(newBook.getISBN());
        oldBook.setTitle(newBook.getTitle());
        //TODO: UPDATE the Authors method - oldBook.setAuthors();
    }

    @Override
    public void removeBook(Book removeBook) {

    }

}
