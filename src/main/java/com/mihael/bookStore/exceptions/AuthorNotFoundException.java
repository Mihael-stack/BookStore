package com.mihael.bookStore.exceptions;

public class AuthorNotFoundException extends Exception{
    public AuthorNotFoundException(String message){
        super(message);
    }
}
