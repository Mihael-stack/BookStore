package com.mihael.bookStore.dao.book;

import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.BookNotFoundException;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class BookDaoJPAProduction implements BookDao{
    @PersistenceContext
    private EntityManager em;


    @Override
    public void addBook(Book book) {
        this.em.persist(book);
    }

    @Override
    public Book findById(Long id) throws BookNotFoundException {
        Book book = this.em.find(Book.class,id);
        if(book == null){
            throw new BookNotFoundException("Book with provided id does not exist!");
        }else return book;
    }

    @Override
    public Book findByISBN(String isbn) throws BookNotFoundException {
        try {
            return this.em.createQuery("SELECT book FROM Book as book WHERE book.ISBN=:isbn", Book.class)
                    .setParameter("isbn", isbn).getSingleResult();
        }catch (javax.persistence.NoResultException e){
            throw new BookNotFoundException("Book not found with provided ISBN");
        }
    }

    @Override
    public List<Book> findByTitle(String title) throws BookNotFoundException {
        List<Book> list = this.em.createQuery("SELECT book FROM Book as book WHERE book.title=:title", Book.class)
                .setParameter("title",title).getResultList();
        if(list.isEmpty()){
            throw new BookNotFoundException("Books not found with provided title");
        }
        return list;
    }

    @Override
    public void updateBook(Book newBook) throws ISBNIsInvalidException {
        Book oldBook = this.em.find(Book.class, newBook.getId());
        oldBook.setISBN(newBook.getISBN());
        oldBook.setTitle(newBook.getTitle());
        oldBook.setAuthors(newBook.getAuthorsUnmodifiable());
    }

    @Override
    public void removeBook(Book removeBook) throws BookNotFoundException {
        Book findBook = findById(removeBook.getId());
        this.em.remove(findBook);
    }

}
