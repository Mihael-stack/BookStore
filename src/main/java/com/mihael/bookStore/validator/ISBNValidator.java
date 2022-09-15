package com.mihael.bookStore.validator;

import com.mihael.bookStore.exceptions.ISBNIsInvalidException;

public abstract class ISBNValidator {
    public String formattingISBN(String isbn){
        char[] split = isbn.toCharArray();
        StringBuilder newISBN = new StringBuilder();
        for(char c : split){
            if(Character.isDigit(c) || Character.isLetter(c)){
                newISBN.append(c);
            }
        }
        return newISBN.toString();
    }
    public void checkISBN(String isbn) throws ISBNIsInvalidException {
        String formattedISBN = formattingISBN(isbn);
        if(formattedISBN.length() == 10){
            boolean isISBNCorrect = checkIfISBN10IsValidAndConvertItToISBN13(formattedISBN);
            if(isISBNCorrect){
                //TODO: convert it to ISBN13
            }
            else{
                throw new ISBNIsInvalidException();
            }
        }
    }


    public static boolean checkIfISBN10IsValidAndConvertItToISBN13(String ISBN){
        char[] split = ISBN.toCharArray();
        int count = 10;
        int result = 0;
        for(char c : split){
            if(Character.isDigit(c)){
                result += count * Integer.parseInt(String.valueOf(c));
                count--;
            }
            if(Character.isLetter(c) && count == 1){
                if(String.valueOf(c).equals("x") || String.valueOf(c).equals("X")){
                    result += count*10;
                }
            }
        }
        int finalResult = result%11;
        if(finalResult == 0) return true;
        else return false;
    }
}
