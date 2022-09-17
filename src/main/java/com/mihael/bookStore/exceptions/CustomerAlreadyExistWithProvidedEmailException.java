package com.mihael.bookStore.exceptions;

public class CustomerAlreadyExistWithProvidedEmailException extends Exception{
    public CustomerAlreadyExistWithProvidedEmailException(String message){
        super(message);
    }
}
