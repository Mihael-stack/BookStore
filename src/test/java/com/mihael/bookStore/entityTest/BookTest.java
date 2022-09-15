package com.mihael.bookStore.entityTest;

import com.mihael.bookStore.entity.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class BookTest {

    @Test
    public void testBooksWithTheSameISBNNumberAreConsideredTheSameProduct(){
        // arrange
        Book one = new Book("15-25-23", "JavaSpring");
        Book two = new Book("15-25-23", "JavaSpring");
        // act
        boolean areTheyEqual = one.equals(two);

        //assert
        assertTrue(areTheyEqual);

    }

}