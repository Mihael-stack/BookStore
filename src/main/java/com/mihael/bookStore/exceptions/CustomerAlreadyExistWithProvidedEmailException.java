package com.mihael.bookStore.exceptions;

public class CustomerAlreadyExistWithProvidedEmailException extends org.springframework.dao.DataIntegrityViolationException{

    public CustomerAlreadyExistWithProvidedEmailException(){
        super("Customer with same email already exists!");
    }
    public CustomerAlreadyExistWithProvidedEmailException(String message){
        super(message);
    }
}
