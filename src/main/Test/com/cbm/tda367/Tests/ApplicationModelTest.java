package com.cbm.tda367.Tests;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Book;
import com.cbm.tda367.model.Listing;
import com.cbm.tda367.model.UserDatabase;
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

        model.addBookToSubscriptionList("TMA660");
        model.removeNotification("TMA660", 1);
        assertEquals(model.getCurrentlyLoggedInUser().getNotifications().size(),0);
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
        List<Listing> listingDatabase = model.getListingDatabase();
        Listing listTest = listingDatabase.get(3);
        model.purchaseDone(listTest);
        assertEquals(model.getCurrentlyLoggedInUser().getPreviouslyTradedListings().size(),1); }

        @Test
    void getListingSellerRating() {
        //model.isLoginSuccessful("1","1");
        //model.addListing("TMA660", "new", "299", "nice");

        //Listing list=model.getCurrentlyLoggedInUser().getPublishedListings().get(0);
        //assertTrue(model.getListingSellerRating(list).);


    }
    @Test
    void getListingCid() {
        model.isLoginSuccessful("1","1");
        model.addListing("TMA660", "new", "299", "nice");
        Listing list=model.getCurrentlyLoggedInUser().getPublishedListings().get(0);
        //assertTrue(list.size()==1);
        assertTrue(model.getListingCid(list).equals("1"));

    }

    @Test
    void isLoginSuccessful() {
        assertTrue(model.isLoginSuccessful("peg@student.chalmers.se","peg123"));

    }

    @Test
    void getCurrentlyLoggedInUser() {
        model.isLoginSuccessful("1","1");
        assertTrue(model.getCurrentlyLoggedInUser().getCid().equals("1"));

    }

    @Test
    void getAllBooks() {
        assertEquals(model.getAllBooks().size(),9);
    }

    @Test
    void getMostSubscribedBooks() {
        List<Book> bookDatabase=model.getAllBooks();
        assertTrue(model.getMostSubscribedBooks().equals(bookDatabase));

    }

    @Test
    void filterBooksByName() {

    }
}