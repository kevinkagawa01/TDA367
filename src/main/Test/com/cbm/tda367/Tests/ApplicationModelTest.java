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
    void editListing() {

        model.editListing("TMA660", "new", "299", "nice", 1);
        List<Listing> listingDatabase = model.getListingDatabase();
        assertEquals(listingDatabase.get(0).getPrice(), "299");
    }

    @Test
    void addListing() {
        List<Listing> listingDatabaseBefore = model.getListingDatabase();
        model.addListing("TMA660", "new", "299", "nice");
        List<Listing> listingDatabaseAfter = model.getListingDatabase();
        assertEquals(listingDatabaseAfter.size(), listingDatabaseBefore.size() + 1);
    }

    @Test
    void sellerRatingNotFoundReturningMinusOne(){
        Listing listingWithNoSeller = model.getListingDatabase().get(0);
        assertEquals(model.getListingSellerRating(listingWithNoSeller), -1);
    }

    @Test
    void sellerRatingFoundReturningRating(){
        model.isLoginSuccessful("1","1");
        model.addListing("TMA660", "new", "299", "nice");
        Listing listingWithSeller = model.getCurrentlyLoggedInUser().getPublishedListings().get(
                model.getCurrentlyLoggedInUser().getPublishedListings().size() - 1);
        assertEquals(model.getListingSellerRating(listingWithSeller),0);

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

        List<Listing> beforeRemovingListing = model.getCurrentlyLoggedInUser().getPublishedListings();
        List<Listing> listingDatabase = model.getListingDatabase();
        model.removedListingFromCurrentlyLoggedInUser(listingDatabase.get(
                listingDatabase.size() - 1));

        List<Listing> afterRemovingListing = model.getCurrentlyLoggedInUser().getPublishedListings();

        assertEquals(beforeRemovingListing.size(), afterRemovingListing.size() + 1);
    }

    @Test
    void addBookToSubscriptionList() {
        model.addBookToSubscriptionList("TMV210");
        assertEquals(model.getCurrentlyLoggedInUser().getSubscribedBooks().size(), 2);
        List<Book> mostSubscribedBooks = model.getMostSubscribedBooks();
        assertEquals(mostSubscribedBooks.get(0).getBookCode(),"TMV210");
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
        assertEquals(model.getCurrentlyLoggedInUser().getPreviouslyTradedListings().size(),1);
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
    void filterBooksByName() {
        List<Book> filteredBookList = model.filterBooksByName("Diskret Matematik");
        assertEquals(filteredBookList.size(), 1);
    }
}