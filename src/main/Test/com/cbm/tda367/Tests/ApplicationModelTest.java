package com.cbm.tda367.Tests;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Listing;
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
    void notifyObservers() {


    }

    @Test
    void addObserver() {

    }

    @Test
    void getListingDatabase() {
        assertEquals(model.getListingDatabase().size(), 6);
    }

    @Test
    void editListing() {

        model.editListing("TMA660","new","299","nice",1);
        List<Listing> listingDatabase = model.getListingDatabase();
        assertEquals(listingDatabase.get(0).getPrice(),"299");
    }

    @Test
    void addListing() {

        model.addListing("TMA660","new","299","nice");
        List<Listing> listingDatabase = model.getListingDatabase();
        assertEquals(listingDatabase.size(),7);
    }

    @Test
    void removeNotification() {
    }

    @Test
    void removedListingFromCurrentlyLoggedInUser() {
    }

    @Test
    void addBookToSubscriptionList() {
    }

    @Test
    void removeBookFromSubscriptionList() {
    }

    @Test
    void reserveListing() {
        List<Listing> listingDatabase = model.getListingDatabase();
        Listing listTest=listingDatabase.get(2);
        model.reserveListing(listTest);
        assertEquals(model.getCurrentlyLoggedInUser().getReservedListings(),1);
    }

    @Test
    void removeBookFromReservedList() {
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