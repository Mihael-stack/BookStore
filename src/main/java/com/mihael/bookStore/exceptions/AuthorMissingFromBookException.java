package com.mihael.bookStore.exceptions;

public class AuthorMissingFromBookException extends Exception {
    public AuthorMissingFromBookException(String message) {
        super(message);
    }
}
