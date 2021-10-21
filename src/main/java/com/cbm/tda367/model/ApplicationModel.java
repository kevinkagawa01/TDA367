package com.cbm.tda367.model;

import java.util.*;

/**
 * Application main class for the model containing the logic of the model.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 0.1
 */
public final class ApplicationModel implements Observable {

    private static ApplicationModel applicationModel;

    private final BookDatabase bookDatabase;
    private final UserDatabase userDatabase;
    private final ListingDatabase listingDatabase;
    private User currentlyLoggedInUser = EmptyUser.getInstance();
    private int currentListingNumber = 1;


    private final List<Observer> viewObservers = new ArrayList<>();

    /**
     * class constructor, private due to Singleton pattern implementation.
     */
    private ApplicationModel() {
        /* init databases */
        bookDatabase = BookDatabase.getInstance();
        userDatabase = UserDatabase.getInstance();
        listingDatabase = ListingDatabase.getInstance();
        /* Update views on start */
        notifyObservers();
    }

    /**
     * Returns single instance of this class.
     *
     * @return single instance of this class.
     */
    public static ApplicationModel getInstance() {
        if(applicationModel == null) {
            applicationModel = new ApplicationModel();
        }
        return applicationModel;
    }

    /**
     * implemented from interface Observable, notifying all observers that change has occured.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : viewObservers) {
            observer.update();
        }
    }

    /**
     * Adds an observer to the lists of observers, watching this class.
     *
     * @param observer observes this class for changes.
     */
    @Override
    public void addObserver(Observer observer) {
        viewObservers.add(observer);
    }

    /**
     * Returns a list of the application's published listings.
     *
     * @return a copied list of listings.
     */
    public List<Listing> getListingDatabase() {
        return listingDatabase.getListings();
    }

    public void editListing(String bookCode, String condition, String price, String description, int editingListingNumber) {
        for (Book book : bookDatabase.getBookList()) {
            if (book.getBookCode().equals(bookCode)) {
                Listing listing = new Listing(book,
                        editingListingNumber,
                        price,
                        book.getImagePath(),
                        condition,
                        description,
                        false,
                        false);
                listingDatabase.editListing(listing);
                currentlyLoggedInUser.editListing(listing);
                notifyObservers();
            }
        }
    }

    /**
     * Adds a listing to the application.
     *
     * @param bookCode  book-code corresponding to the book the User wants to sell.
     * @param condition the listings condition.
     * @param price     the listings price.
     */
    public void addListing(String bookCode, String condition, String price, String description) {
        for (Book book : bookDatabase.getBookList()) {
            if (book.getBookCode().equals(bookCode)) {
                Listing listing = new Listing(book,
                        currentListingNumber++,
                        price,
                        book.getImagePath(),
                        condition,
                        description, false, false);
                listingDatabase.addListing(listing);
                currentlyLoggedInUser.addListingForSale(listing);
                notifyObservers();
                //TODO: else-block should enable user to create a new book for the bookDatabase if not current one matches.
            }
        }
    }

    public void removedListingFromCurrentlyLoggedInUser(Listing listing) {
        /* Delete removed listing from Database */
        listingDatabase.removeListing(listing);

        /* Delete removed listing from user */
        currentlyLoggedInUser.removeListingForSale(listing);

        /* Update view */
        notifyObservers();
    }

    public void addBookToSubscriptionList(String bookName) {
        for (Book book : bookDatabase.getBookList()) {
            if (book.getBookName().equals(bookName) && !currentlyLoggedInUser.getSubscribedBooks().contains(book)) {
                currentlyLoggedInUser.addBookSubscription(book);
                bookDatabase.incrementSubscription(book.getBookCode());
                notifyObservers();

            }
        }
    }

    public void removeBookFromSubscriptionList(String bookCode) {
        /* remove book from subscription list  */
        currentlyLoggedInUser.removeBookSubscription(bookCode);
        /* decrement number of subscriptions on the book */
        bookDatabase.decrementSubscription(bookCode);
        /*   */

        /* Update view */
        notifyObservers();
    }

    public void reserveListing(Listing listing) {
        currentlyLoggedInUser.addReservedBook(listing);
        listingDatabase.reserveListing(listing);
        /* Update view */
        notifyObservers();
    }

    public void removeBookFromReservedList(Listing listing) {
        listingDatabase.removeListing(listing);

        /* remove book from subscription list  */
        currentlyLoggedInUser.removeReservedBook(listing);
        /* Update view */
        notifyObservers();
    }

    public void purchaseDone(Listing listing) {
        //currentlyLoggedInUser.addPreviousPurchase(listing);
        boolean isPurchasedOkBySeller = true;
        boolean isPurchasedOkByBuyer = true;

        if (isPurchasedOkByBuyer) {
            if (isPurchasedOkBySeller) {
                currentlyLoggedInUser.addPreviousPurchase(listing);
                currentlyLoggedInUser.removeReservedBook(listing);

                /* Update view */
                notifyObservers();

            }

        }
    }




    public void removePurchaseListingBooks(Listing listing) {
        listingDatabase.removeListing(listing);
        currentlyLoggedInUser.removePreviousPurchase(listing);

        /* Update view */
        notifyObservers();

    }

    public double getListingSellerRating(Listing listing) {
        for (User user : userDatabase.getUserList()) {
            for (Listing listing1 : user.getBooksForSale()) {
                if (listing1.getListingNumber() == listing.getListingNumber()) {
                    return user.getRating();
                }
            }
        }
        return -1;
    }

    public String getListingCid(Listing listing) {
        for (User user : userDatabase.getUserList()) {
            for (Listing listing1 : user.getBooksForSale()) {
                if (listing1.getListingNumber() == listing.getListingNumber()) {
                    return user.getCid();
                }
            }
        }
        return "";
    }


    /**
     * Determining whether login attempt was successful or not.
     *
     * @param cid      User chalmers identification.
     * @param password User password.
     * @return boolean whether the login attempt was successful or not.
     */
    public boolean isLoginSuccessful(String cid, String password) {
        for (User user : userDatabase.getUserList()) {
            if (user.getCid().equals(cid) && user.isUserPassword(password)) {
                currentlyLoggedInUser = user;
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the user that is currently logged in to the application.
     *
     * @return the currently logged-in user.
     */
    public User getCurrentlyLoggedInUser() {
        return currentlyLoggedInUser.cloneObject();
    }

    public List<Book> getAllBooks() {
        return bookDatabase.getBookList();
    }

    public List<Book> getMostSubscribedBooks() {
        List<Book> allBooks = bookDatabase.getBookList();

        for (int i = 0; i < allBooks.size(); i++) {
            for (int j = i + 1; j < allBooks.size(); j++) {
                if (allBooks.get(j).getBookSubscriptions() > allBooks.get(i).getBookSubscriptions()) {
                    Book tmpBook = allBooks.get(j);
                    allBooks.set(j, allBooks.get(i));
                    allBooks.set(i, tmpBook);
                }
            }
        }

        return allBooks;
    }

    public List<Book> filterBooksByName(String filter) {
        /* Filtered books */
        List<Book> filteredBooks = new ArrayList<>();
        /* All books from database */
        List<Book> allBooks = bookDatabase.getBookList();

        for (Book book : allBooks) {
            if (book.getBookName().toLowerCase(Locale.ROOT).contains(filter.toLowerCase(Locale.ROOT))) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }
}
