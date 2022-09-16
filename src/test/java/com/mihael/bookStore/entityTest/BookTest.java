package com.mihael.bookStore.entityTest;

import com.mihael.bookStore.entity.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BookTest {

    @Test
    public void testBooksWithTheSameISBNNumberAreConsideredTheSameProduct(){
        //TODO: Fix The Test
        // arrange
        //Book one = new Book("15-25-23", "JavaSpring");
       // Book two = new Book("15-25-23", "JavaSpring");
        // act
        //boolean areTheyEqual = one.equals(two);

        //assert
        //assertTrue(areTheyEqual);
    }
    @Test
    public void testIfMethodCheckIfISBN10IsValidAndConvertItToISBN13isWorking(){
        // TODO: Change to whole books inserts after ISBNValidator is done
        // arrange
        String isbn1 = "161-729-75-77";
        String isbn2 = "14-932-22-953";
        String isbn3 = "1-55404-295-X";
        String isbnBad = "1617298571";
        String isbnBad2 = "161-72-98571";
        String isbnBad3 = "161-72-98X71";
        String isbnBad4 = "16L-72-98X71";
        // act

        //assert

//        assertTrue(Book.checkIfISBN10IsValidAndConvertItToISBN13(isbn1));
//        assertTrue(Book.checkIfISBN10IsValidAndConvertItToISBN13(isbn2));
//        assertTrue(Book.checkIfISBN10IsValidAndConvertItToISBN13(isbn3));
//
//        assertFalse(Book.checkIfISBN10IsValidAndConvertItToISBN13(isbnBad));
//        assertFalse(Book.checkIfISBN10IsValidAndConvertItToISBN13(isbnBad2));
//        assertFalse(Book.checkIfISBN10IsValidAndConvertItToISBN13(isbnBad3));
    }

}