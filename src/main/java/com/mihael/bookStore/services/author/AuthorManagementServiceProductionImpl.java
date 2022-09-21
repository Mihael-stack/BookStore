package com.mihael.bookStore.services.author;

import com.mihael.bookStore.dao.author.AuthorDao;
import com.mihael.bookStore.entity.Address;
import com.mihael.bookStore.entity.Author;
import com.mihael.bookStore.exceptions.AddressNotFoundException;
import com.mihael.bookStore.exceptions.AuthorNotFoundException;
import com.mihael.bookStore.services.address.AddressManagementService;

import java.util.List;

public class AuthorManagementServiceProductionImpl implements AuthorManagementService{

    private final AuthorDao dao;
    private final AddressManagementService addressService;

    public AuthorManagementServiceProductionImpl(AuthorDao dao, AddressManagementService addressService){
        this.dao = dao;
        this.addressService = addressService;
    }

    @Override
    public void addNewAuthor(Author author) {
        this.dao.addAuthor(author);
    }

    @Override
    public void addNewAuthorWithAddress(Author author, Address address) {
        this.addressService.addNewAddress(address);
        author.setAddress(address);
        this.dao.addAuthor(author);
    }

    @Override
    public void removeAuthor(Author removeAuthor) {
        this.dao.deleteAuthor(removeAuthor);
    }

    @Override
    public void removeAuthorsAddress(Author author) throws AddressNotFoundException, AuthorNotFoundException {
        Author persistAuthor = this.findAuthorById(author.getId());
        Address address = this.addressService.findAddress(persistAuthor.getAddressReadOnly().getId());
        persistAuthor.setAddress(null);
        this.addressService.deleteAddress(address);
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
    public List<Author> findAuthorByAlias(String alias) throws AuthorNotFoundException {
        return this.dao.findByAlias(alias);
    }

    @Override
    public void updateAuthor(Author newAuthor) {
        this.dao.updateAuthor(newAuthor);
    }
}
