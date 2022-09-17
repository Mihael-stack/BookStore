package com.mihael.bookStore.entityTest;

import com.mihael.bookStore.entity.Book;
import com.mihael.bookStore.exceptions.ISBNIsInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BookTest {

    @Test
    public void testBooksWithTheSameISBNNumberAreConsideredTheSameProduct() throws ISBNIsInvalidException {
        // arrange
        Book one1 = new Book("0385546025", "JavaSpring");
        Book two1 = new Book("0385546025", "JavaSpring2");
        Book one2 = new Book("6167611246", "NewHemi");
        Book two2 = new Book("6167611246", "OldHemi");
        Book one3 = new Book("978-1777189778", "newnew");
        Book two3 = new Book("978-1777189778", "oldold");
        // act
        boolean areTheyEqual1 = one1.equals(two1);
        boolean areTheyEqual2 = one2.equals(two2);
        boolean areTheyEqual3 = one3.equals(two3);
        //assert
        assertTrue(areTheyEqual1);
        assertTrue(areTheyEqual2);
        assertTrue(areTheyEqual3);
    }
    @Test
    public void testIfSameISBN10andISBN13areConsideredSameISBN() throws ISBNIsInvalidException {
        Book one1 = new Book("1777189772", "JavaSpring");
        Book two1 = new Book("978-1777189778", "JavaSpring2");
        Book one2 = new Book("1955924058", "NewHemi");
        Book two2 = new Book("978-1955924054", "OldHemi");
        Book one3 = new Book("0-8692-9850-X", "newnew");
        Book two3 = new Book("978-0-86929-850-3", "oldold");

        boolean areTheyEqual1 = one1.equals(two1);
        boolean areTheyEqual2 = one2.equals(two2);
        boolean areTheyEqual3 = one3.equals(two3);
        //assert
        assertTrue(areTheyEqual1);
        assertTrue(areTheyEqual2);
        assertTrue(areTheyEqual3);

    }

}