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

    private Integer currentListingNumber = 1;


    private final List<Observer> viewObservers = new ArrayList<>();

    /**
     * class constructor, private due to Singleton pattern implementation.
     */
    private ApplicationModel() {
        /* init databases */
        bookDatabase = BookDatabase.getInstance();
        userDatabase = UserDatabase.getInstance();
        listingDatabase = ListingDatabase.getInstance();
        currentListingNumber = listingDatabase.getListings().size() + 1;

        /* Update views on start */
        notifyObservers();
    }

    /**
     * Returns single instance of this class.
     *
     * @return single instance of this class.
     */
    public static ApplicationModel getInstance() {
        if (applicationModel == null) {
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
                currentlyLoggedInUser.receiveSubscribeNotification(bookCode);
                userDatabase.updateUser(currentlyLoggedInUser);
                notifyObservers();
                //TODO: else-block should enable user to create a new book for the bookDatabase if not current one matches.
            }
        }
    }

    /**
     * Removes desired number of subscription-notifications from notifications.
     *
     * @param bookCode                  book code to the book related to the notifications wished to be removed.
     * @param nNotificationsToBeRemoved number of notifications to be removed.
     */
    public void removeNotification(String bookCode, int nNotificationsToBeRemoved) {
        currentlyLoggedInUser.removeSubscribeNotification(bookCode, nNotificationsToBeRemoved);
    }

    /**
     * Removes a listing from the currently logged-in user.
     *
     * @param listing listing to be removed.
     */
    public void removedListingFromCurrentlyLoggedInUser(Listing listing) {
        /* Delete removed listing from Database */
        listingDatabase.removeListing(listing);
        /* Delete removed listing from user */
        currentlyLoggedInUser.removeListingForSale(listing);
        currentlyLoggedInUser.removeSubscribeNotification(listing.getBook().getBookCode(), 1);
        userDatabase.updateUser(getCurrentlyLoggedInUser());

        /* Update view */
        notifyObservers();
    }

    /**
     * Subscribes to a book for the currently logged-in user.
     *
     * @param bookCode book code to corresponding book desired to be subscribed to.
     */
    public void addBookToSubscriptionList(String bookCode) {
        List<Book> userSubscribedBooks = currentlyLoggedInUser.getSubscribedBooks();
        for (Book b : userSubscribedBooks) {
            if (b.getBookCode().equals(bookCode)) {
                return;
            }
        }
        for (Book book : bookDatabase.getBookList()) {
            if (book.getBookCode().equals(bookCode)) {
                currentlyLoggedInUser.addBookSubscription(book);
                bookDatabase.incrementSubscription(book.getBookCode());
                notifyObservers();

            }
        }
    }

    /**
     * Unsubscribes to a book for the currently logged-in user.
     *
     * @param bookCode book code to corresponding book desired to be unsubscribed to.
     */
    public void removeBookFromSubscriptionList(String bookCode) {
        /* remove book from subscription list  */
        currentlyLoggedInUser.removeBookSubscription(bookCode);
        /* decrement number of subscriptions on the book */
        bookDatabase.decrementSubscription(bookCode);
        /*   */

        /* Update view */
        notifyObservers();
    }

    /**
     * Reserves a listing for the currently logged-in user.
     *
     * @param listing listing to be reserved.
     * @return bool flag whether the request was possible or not.
     */
    public boolean reserveListing(Listing listing) {
        List<Listing> publishedListings = currentlyLoggedInUser.getPublishedListings();
        boolean isPublisher = false;

        for (Listing l : publishedListings) {
            if (l.getListingNumber() == listing.getListingNumber()) {
                isPublisher = true;
            }
        }

        if (!isPublisher) {
            currentlyLoggedInUser.addReservedBook(listing);
            listingDatabase.reserveListing(listing);
            userDatabase.updateUser(currentlyLoggedInUser);
            /* Update view */
            notifyObservers();
            return true;
        }
        return false;
    }

    /**
     * Removes a book from currently logged-in user's reserved listings.
     *
     * @param listing Listing to be removed.
     */
    public void removeBookFromReservedList(Listing listing) {
        listingDatabase.unreserveListing(listing);

        /* remove book from subscription list  */
        currentlyLoggedInUser.removeReservedBook(listing);
        /* Update view */
        notifyObservers();
    }

    /**
     * Confirms purchase if both parts accept that the trade was successful.
     *
     * @param listing listing to determine whether the purchase was complete or not.
     */
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

    /**
     * Returns seller's rating related to the attached listing.
     *
     * @param listing listing to determine which user is the seller.
     * @return user's rating if operation was successful, otherwise -1.
     */
    public double getListingSellerRating(Listing listing) {
        for (User user : userDatabase.getUserList()) {
            for (Listing listing1 : user.getPublishedListings()) {
                if (listing1.getListingNumber() == listing.getListingNumber()) {
                    return user.getUserRating().getRating();
                }
            }
        }
        return -1;
    }

    /**
     * Returns seller's cid related to the attached listing.
     *
     * @param listing listing to determine which user is the seller.
     * @return user's cid if operation was successful, otherwise "".
     */
    public String getListingCid(Listing listing) {
        for (User user : userDatabase.getUserList()) {
            for (Listing listing1 : user.getPublishedListings()) {
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

    /**
     * Returns all books from the book database.
     *
     * @return all books from the book database
     */
    public List<Book> getAllBooks() {
        return bookDatabase.getBookList();
    }

    /**
     * Returns books with most subscriptions.
     *
     * @return List of books with most subscriptions.
     */
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

    /**
     * Filters book by name, given the parameter string as filter.
     *
     * @param filter string to compare if book titles contain it.
     * @return List of books filtered by the filter.
     */
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
