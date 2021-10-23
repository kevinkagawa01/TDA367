package com.cbm.tda367.Tests;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.EmptyBook;
import com.cbm.tda367.model.EmptyListing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyListingTest {

    ApplicationModel model;
    EmptyListing emptyListing;

    @BeforeEach
    public void testSetUp() {
        model = ApplicationModel.getInstance();
        emptyListing = EmptyListing.getInstance();
    }

    @Test
    void emptyBookTest(){
        assertEquals(emptyListing.getPrice(),"");
        assertEquals(emptyListing.getListingDescription(),"");
        assertEquals(emptyListing.getListingNumber(),-1);
        assertEquals(emptyListing.getBook(),EmptyBook.getInstance());
        assertEquals(emptyListing.getCondition(),"");
        assertEquals(emptyListing.getImage(),"");
    }
}
