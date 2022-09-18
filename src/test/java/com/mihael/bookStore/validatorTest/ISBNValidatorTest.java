package com.mihael.bookStore.validatorTest;

import com.mihael.bookStore.exceptions.ISBNIsInvalidException;
import com.mihael.bookStore.validator.ISBNValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ISBNValidatorTest {

    @Test
    void formattingISBN() {
        // arrange
        String isbn1 = "173@@410##8)(258";
        String isbn2 = "17!34**108282";
        String isbn3 = "0-7469-9768-X";
        String isbn4 = "123123-----";
        String isbn5 = "0-LX-223-**001";
        //act
        String formattedISBN1 = ISBNValidator.formattingISBN(isbn1);
        String formattedISBN2 = ISBNValidator.formattingISBN(isbn2);
        String formattedISBN3 = ISBNValidator.formattingISBN(isbn3);
        String formattedISBN4 = ISBNValidator.formattingISBN(isbn4);
        String formattedISBN5 = ISBNValidator.formattingISBN(isbn5);
        //assert
        assertEquals("1734108258",formattedISBN1);
        assertEquals("1734108282",formattedISBN2);
        assertEquals("074699768X",formattedISBN3);
        assertEquals("123123",formattedISBN4);
        assertEquals("0LX223001",formattedISBN5);
    }

    @Test
    void checkIfISBN13IsValid() throws ISBNIsInvalidException {
        //arrange
        String isbn1 = "978-1-6374-6905-7";
        String isbn2 = "978-2-7727-1383-8";
        String isbn3 = "978-0-8760-9621-5";
        String isbn4 = "978-7-6700-3929-5";
        String isbn5 = "978-3-6696-8798-0";
        String isbn6 = "978-0-7257-2025-4";
        String isbn7 = "978-0-513-10044-2";
        String isbn8 = "978-0-7469-9768-0";
        String isbn9 = "978-1955924054";
        String isbn10 = "978-1777189778";
        String isbn11 = "978-1777189716";
        String isbn12 = "978-0385546027";
        String isbn13 = "978-1684338580";
        //act
        String isIsbn1 = ISBNValidator.checkISBN(isbn1);
        String isIsbn2 = ISBNValidator.checkISBN(isbn2);
        String isIsbn3 = ISBNValidator.checkISBN(isbn3);
        String isIsbn4 = ISBNValidator.checkISBN(isbn4);
        String isIsbn5 = ISBNValidator.checkISBN(isbn5);
        String isIsbn6 = ISBNValidator.checkISBN(isbn6);
        String isIsbn7 = ISBNValidator.checkISBN(isbn7);
        String isIsbn8 = ISBNValidator.checkISBN(isbn8);
        String isIsbn9 = ISBNValidator.checkISBN(isbn9);
        String isIsbn10 = ISBNValidator.checkISBN(isbn10);
        String isIsbn11 = ISBNValidator.checkISBN(isbn11);
        String isIsbn12 = ISBNValidator.checkISBN(isbn12);
        String isIsbn13 = ISBNValidator.checkISBN(isbn13);


        //assert
        assertEquals("9781637469057",isIsbn1);
        assertEquals("9782772713838",isIsbn2);
        assertEquals("9780876096215",isIsbn3);
        assertEquals("9787670039295",isIsbn4);
        assertEquals("9783669687980",isIsbn5);
        assertEquals("9780725720254",isIsbn6);
        assertEquals("9780513100442",isIsbn7);
        assertEquals("9780746997680",isIsbn8);
        assertEquals("9781955924054",isIsbn9);
        assertEquals("9781777189778",isIsbn10);
        assertEquals("9781777189716",isIsbn11);
        assertEquals("9780385546027",isIsbn12);
        assertEquals("9781684338580",isIsbn13);


    }
    @Test
    void checkIfISBN13IsInvalid(){
        //arrange
        String isbn1 = "978-6-4299-4124-2";
        String isbn2 = "978-1-3676-4815-2";
        String isbn3 = "978-6-9608-8512-9";
        String isbn4 = "978-9-7497-8643-0";
        String isbn5 = "978-5-9772-1129-7";
        String isbn6 = "978-9-4998-2953-3";
        String isbn7 = "978-8-6318-4884-X";
        String isbn8 = "978-6-880S-2485-L";
        String isbn9 = "978-9-5473-8321-4";
        String isbn10 = "978-5-2065-8522-8";
        //act-assert
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn1));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn2));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn3));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn4));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn5));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn6));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn7));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn8));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn9));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn10));
    }

    @Test
    void checkIfISBN10IsValid() throws ISBNIsInvalidException {
        String isbn1 = "1982138009";
        String isbn2 = "1982173629";
        String isbn3 = "0062834851";
        String isbn4 = "1496726510";
        String isbn5 = "1496713680";
        String isbn6 = "1496713664";
        String isbn7 = "1542028051";
        String isbn8 = "1684338581";
        String isbn9 = "0385546025";
        String isbn10 = "6167611246";
        String isbn11 = "1777189713";
        String isbn12 = "1777189772";
        String isbn13 = "1955924031";
        String isbn14 = "1955924058";
        String isbn15 = "0-7469-9768-X";
        String isbn16 = "0-5649-2895-X";
        String isbn17 = "0-5131-0044-X";
        String isbn18 = "0-8692-9850-X";
        String isbn19 = "173@@410##8)(258";
        String isbn20 = "17!34**108282";
        //act
        String isIsbn1 = ISBNValidator.checkISBN(isbn1);
        String isIsbn2 = ISBNValidator.checkISBN(isbn2);
        String isIsbn3 = ISBNValidator.checkISBN(isbn3);
        String isIsbn4 = ISBNValidator.checkISBN(isbn4);
        String isIsbn5 = ISBNValidator.checkISBN(isbn5);
        String isIsbn6 = ISBNValidator.checkISBN(isbn6);
        String isIsbn7 = ISBNValidator.checkISBN(isbn7);
        String isIsbn8 = ISBNValidator.checkISBN(isbn8);
        String isIsbn9 = ISBNValidator.checkISBN(isbn9);
        String isIsbn10 = ISBNValidator.checkISBN(isbn10);
        String isIsbn11 = ISBNValidator.checkISBN(isbn11);
        String isIsbn12 = ISBNValidator.checkISBN(isbn12);
        String isIsbn13 = ISBNValidator.checkISBN(isbn13);
        String isIsbn14 = ISBNValidator.checkISBN(isbn14);
        String isIsbn15 = ISBNValidator.checkISBN(isbn15);
        String isIsbn16 = ISBNValidator.checkISBN(isbn16);
        String isIsbn17 = ISBNValidator.checkISBN(isbn17);
        String isIsbn18 = ISBNValidator.checkISBN(isbn18);
        String isIsbn19 = ISBNValidator.checkISBN(isbn19);
        String isIsbn20 = ISBNValidator.checkISBN(isbn20);


        //assert
        assertEquals("9781982138004",isIsbn1);
        assertEquals("9781982173623",isIsbn2);
        assertEquals("9780062834850",isIsbn3);
        assertEquals("9781496726513",isIsbn4);
        assertEquals("9781496713681",isIsbn5);
        assertEquals("9781496713667",isIsbn6);
        assertEquals("9781542028059",isIsbn7);
        assertEquals("9781684338580",isIsbn8);
        assertEquals("9780385546027",isIsbn9);
        assertEquals("9786167611242",isIsbn10);
        assertEquals("9781777189716",isIsbn11);
        assertEquals("9781777189778",isIsbn12);
        assertEquals("9781955924030",isIsbn13);
        assertEquals("9781955924054",isIsbn14);
        assertEquals("9780746997680",isIsbn15);
        assertEquals("9780564928958",isIsbn16);
        assertEquals("9780513100442",isIsbn17);
        assertEquals("9780869298503",isIsbn18);
        assertEquals("9781734108255",isIsbn19);
        assertEquals("9781734108286",isIsbn20);
    }
    @Test
    void checkIfISBN10IsInvalid(){
        //arrange
        String isbn1 = "0-2247-5502-X";
        String isbn2 = "0-2999-3393-2";
        String isbn3 = "0-1602-8551-1";
        String isbn4 = "0-2510-2897-2";
        String isbn5 = "0-3978-2402-9";
        String isbn6 = "0-6123-0494-0";
        String isbn7 = "0-LX-223-**001";
        String isbn8 = "XX-22-333-23";
        String isbn9 = "0--5502-X";
        String isbn10 = "123123-----";
        //act-assert
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn1));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn2));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn3));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn4));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn5));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn6));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn7));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn8));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn9));
        assertThrows(ISBNIsInvalidException.class, () -> ISBNValidator.checkISBN(isbn10));
    }
}