package com.cbm.tda367.Tests;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.EmptyUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyUserTest {

    ApplicationModel model;
    EmptyUser emptyUser;

    @BeforeEach
    public void testSetUp() {
        model = ApplicationModel.getInstance();
        emptyUser = EmptyUser.getInstance();
    }

    @Test
    void emptyBookTest(){
        assertEquals(emptyUser.getCid(),"");
        assertEquals(emptyUser.getSubscribedBooks().size(),0);
        assertEquals(emptyUser.getPublishedListings().size(),0);
        assertEquals(emptyUser.getReservedListings().size(),0);
        assertEquals(emptyUser.getPreviouslyTradedListings().size(),0);
        assertEquals(emptyUser.getNotifications().size(),0);
        assertEquals(emptyUser.getUserRating().getRating(),0);
    }
}
