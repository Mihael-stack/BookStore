package com.mihael.bookStore.validator;

import com.mihael.bookStore.exceptions.ISBNIsInvalidException;

public abstract class ISBNValidator {
    public static String formattingISBN(String isbn){
        char[] split = isbn.toCharArray();
        StringBuilder newISBN = new StringBuilder();
        for(char c : split){
            if(Character.isDigit(c) || Character.isLetter(c)){
                newISBN.append(c);
            }
        }
        return newISBN.toString();
    }
    public static String checkISBN(String isbn) throws ISBNIsInvalidException {
        String formattedISBN = formattingISBN(isbn);
        if(formattedISBN.length() == 10){
            boolean isISBNCorrect = checkIfISBN10IsValid(formattedISBN);
            if(isISBNCorrect){
                //TODO: convert it to ISBN13 - If there is not a second version of commons validator, manually write the method
                return org.apache.commons.validator.routines.ISBNValidator.getInstance().convertToISBN13(formattedISBN);
            }
            else{
                throw new ISBNIsInvalidException("The provided ISBN-10 is an invalid ISBN");
            }
        }
        if(formattedISBN.length() == 13){
            if(checkIfISBN13IsValid(formattedISBN)) return formattedISBN;
            else throw new ISBNIsInvalidException("The provided ISBN-13 is an invalid ISBN");
        }
        else throw new ISBNIsInvalidException("The provided ISBN is invalid");
    }

    public static boolean checkIfISBN13IsValid(String ISBN){ // Reminder - Needs to be called together with ISBNFormatted
        char[] split = ISBN.toCharArray();
        int result = 0;
        int count = 1;
        for(char c : split){
            if(!Character.isDigit(c)){
                return false;
            }
            else{
                if(count % 2 == 0){
                    result += Integer.parseInt(String.valueOf(c)) * 3;
                    count++;
                }
                else{
                    result += Integer.parseInt(String.valueOf(c));
                    count++;
                }
            }

        }
        int finalResult  = result % 10;

        return finalResult == 0;
    }


    public static boolean checkIfISBN10IsValid(String ISBN){
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
        return finalResult == 0;
    }
}
