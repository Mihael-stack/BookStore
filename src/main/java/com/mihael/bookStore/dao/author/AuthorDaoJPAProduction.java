package com.mihael.bookStore.dao.author;

import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.exceptions.AuthorNotFoundException;
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
    public Author findById(Long id) throws AuthorNotFoundException {
        if(this.em.find(Author.class, id) == null){
            throw new AuthorNotFoundException("Author does not exist!");
        }else return this.em.find(Author.class, id);
    }

    @Override
    public List<Author> findByName(String name) throws AuthorNotFoundException {
        List<Author> list = this.em.createQuery("SELECT author FROM Author as author WHERE author.name=:name",Author.class)
                .setParameter("name",name).getResultList();
        if(list.isEmpty()){
            throw new AuthorNotFoundException("There isn't any Authors with specified name");
        }else return list;
    }
    @Override
    public List<Author> findByAlias(String alias) throws AuthorNotFoundException {
        List<Author> list = this.em.createQuery("SELECT author FROM Author as author WHERE author.alias=:alias", Author.class)
                .setParameter("alias",alias).getResultList();
        if(list.isEmpty()){
            throw new AuthorNotFoundException("There isn't any Authors with specified alias");
        }else return list;
    }


    @Override
    public void updateAuthor(Author newAuthor) {
        Author oldAuthor = this.em.find(Author.class,newAuthor.getId());
        oldAuthor.setName(newAuthor.getName());
        oldAuthor.setAlias(newAuthor.getAlias());
        oldAuthor.setAddress(newAuthor.getAddress());
        oldAuthor.setBooksWritten(newAuthor.getBooksWrittenUnmodifiable());
    }

    @Override
    public void deleteAuthor(Author removeAuthor) {
        Author author = em.find(Author.class, removeAuthor.getId());
        this.em.remove(author);
    }
}
