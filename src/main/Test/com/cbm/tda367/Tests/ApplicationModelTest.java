package com.cbm.tda367.Tests;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Listing;
import com.cbm.tda367.viewcontroller.BookDetailViewController;
import com.cbm.tda367.viewcontroller.ControllerManager;
import com.cbm.tda367.viewcontroller.ShopPageViewController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationModelTest {

    ApplicationModel model;


    @BeforeEach
    public void testSetUp() {
        model = ApplicationModel.getInstance();

    }

    @Test
    void getListingDatabase() {
        assertEquals(model.getListingDatabase().size(), 6);
    }

    @Test
    void editListing() {

        model.editListing("TMA660", "new", "299", "nice", 1);
        List<Listing> listingDatabase = model.getListingDatabase();
        assertEquals(listingDatabase.get(0).getPrice(), "299");
    }

    @Test
    void addListing() {

        model.addListing("TMA660", "new", "299", "nice");
        List<Listing> listingDatabase = model.getListingDatabase();
        assertEquals(listingDatabase.size(), 7);
    }

    @Test
    void removeNotification() {
/*
        model.addBookToSubscriptionList("TMA660");
        model.removeNotification("TMA660", 1);
        assertEquals(model.getCurrentlyLoggedInUser().getSubscribeNotifications(), 0);*/
    }

    @Test
    void removedListingFromCurrentlyLoggedInUser() {
        model.addListing("TMA660", "new", "399", "lol");
        List<Listing> listingDatabase = model.getListingDatabase();
        model.removedListingFromCurrentlyLoggedInUser(listingDatabase.get(6));
        assertEquals(model.getCurrentlyLoggedInUser().getPublishedListings().size(), 0);
    }

    @Test
    void addBookToSubscriptionList() {
        model.addBookToSubscriptionList("TMA660");
        assertEquals(model.getCurrentlyLoggedInUser().getSubscribedBooks().size(), 1);
    }

    @Test
    void removeBookFromSubscriptionList() {
        model.addBookToSubscriptionList("TMA660");
        model.removeBookFromSubscriptionList("TMA660");
        assertTrue(model.getCurrentlyLoggedInUser().getSubscribedBooks().isEmpty());

    }

    @Test
    void reserveListing() {
        List<Listing> listingDatabase = model.getListingDatabase();
        Listing listTest = listingDatabase.get(2);
        model.reserveListing(listTest);
        assertEquals(model.getCurrentlyLoggedInUser().getReservedListings().size(), 1);
    }

    @Test
    void removeBookFromReservedList() {
        List<Listing> listingDatabase = model.getListingDatabase();
        Listing listTest = listingDatabase.get(2);
        model.reserveListing(listTest);
        model.removeBookFromReservedList(listTest);
        assertEquals(model.getCurrentlyLoggedInUser().getReservedListings().size(), 0);

    }

    //***************************************************************************//
    @Test
    void purchaseDone() {
    }


    @Test
    void removePurchaseListingBooks() {
    }

    @Test
    void getListingSellerRating() {
    }

    @Test
    void getListingCid() {
    }

    @Test
    void isLoginSuccessful() {
    }

    @Test
    void getCurrentlyLoggedInUser() {
    }

    @Test
    void getAllBooks() {
    }

    @Test
    void getMostSubscribedBooks() {
    }

    @Test
    void filterBooksByName() {
    }
}