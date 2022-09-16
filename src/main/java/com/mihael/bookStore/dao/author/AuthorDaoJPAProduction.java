package com.mihael.bookStore.dao.author;

import com.mihael.bookStore.entity.Author;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional
public class AuthorDaoJPAProduction implements AuthorDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addAuthor(Author author) {
        this.em.persist(author);
    }

    @Override
    public Author findById(int id) {
        return this.em.find(Author.class, id);
    }

    @Override
    public List<Author> findByName(String name) {
        return this.em.createQuery("SELECT author FROM Author as author WHERE author.name=:name",Author.class)
                .setParameter("name",name).getResultList();
    }

    @Override
    public void updateAuthor(Author newAuthor) {
        Author oldAuthor = this.em.find(Author.class,newAuthor.getId());
        oldAuthor.setName(newAuthor.getName());
        oldAuthor.setAlias(newAuthor.getAlias());
        // TODO: Fix Address
        //oldAuthor.setAddress(newAuthor.setAddress());
        oldAuthor.setBooksWritten(newAuthor.getBooksWritten());
    }

    @Override
    public void deleteAuthor(Author removeAuthor) {
        Author author = em.find(Author.class, removeAuthor.getId());
        this.em.remove(author);
    }

}