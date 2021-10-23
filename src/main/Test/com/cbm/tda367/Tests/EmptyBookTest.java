package com.cbm.tda367.Tests;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.EmptyBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyBookTest {

    ApplicationModel model;
    EmptyBook emptyBook;

    @BeforeEach
    public void testSetUp() {
        model = ApplicationModel.getInstance();
        emptyBook = EmptyBook.getInstance();
    }

    @Test
    void emptyBookTest(){
        assertEquals(emptyBook.getBookName(),"");
        assertEquals(emptyBook.getBookCode(),"");
        assertEquals(emptyBook.getImagePath(),"");
        assertEquals(emptyBook.getBookAuthor(),"");
        assertEquals(emptyBook.getBookSales(),0);
        assertEquals(emptyBook.getBookSubscriptions(),0);
        assertEquals(emptyBook.getCategory(),"");
    }
}
