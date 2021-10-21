package com.cbm.tda367.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an application user.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 0.3
 * @since 0.1
 */
public class User implements Prototype<User>{

    private String cid;
    private String password;
    private double totalRating;
    private int sumOfRatings;
    private int nrRatings;

    /* user lists */
    private List<Listing> reservedBooks;
    private List<Listing> booksForSale;
    private List<Book> subscribedBooks;
    private List<Listing> previousPurchases;
    private List<Notification> notifications;

    /**
     * class constructor.
     *
     * @param cid      this chalmers identification.
     * @param password this password.
     */
    User(String cid, String password) {
        this.cid = cid;
        this.password = password;
        this.totalRating = 0;
        this.sumOfRatings = 0;
        this.nrRatings = 0;
        this.reservedBooks = new ArrayList<>();
        this.booksForSale = new ArrayList<>();
        this.subscribedBooks = new ArrayList<>();
        this.previousPurchases = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    private User(User user){
        this.cid = user.cid;
        this.password = user.password;
        this.totalRating = user.totalRating;
        this.sumOfRatings = user.sumOfRatings;
        this.nrRatings = user.nrRatings;
        /* safe copied lists */
        this.reservedBooks = user.getReservedBooks();
        this.booksForSale = user.getBooksForSale();
        this.subscribedBooks = user.getSubscribedBooks();
        this.previousPurchases = user.getPreviousPurchases();
        this.notifications = user.getNotifications();
    }

    /**
     * Returns a safe copy of object.
     * @return safe copy of object.
     */
    @Override
    public User cloneObject() {
        return new User(this);
    }

    /**
     * adds users rating and updates the total
     *
     * @param rating rating to be added to this total rating.
     */
    void addRating(int rating) {
        /* if provided rating is invalid, return */
        if (!(0 <= rating && rating <= 5)) {
            return;
        }
        /* add rating to total sum of ratings */
        sumOfRatings += rating;
        /* increment number of raters */
        nrRatings++;
        /* round rating to one decimal place and split the total sum according to number of ratings */
        totalRating = round((double) sumOfRatings / nrRatings, 1);
    }

    /**
     * Returns this rating.
     *
     * @return this rating.
     */
    public double getRating() {
        return totalRating;
    }

    /**
     * rounds a double to a certain precision
     *
     * @param value     double to be rounded.
     * @param precision precision to round the double according to.
     * @return rounded double.
     */
    private double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    /**
     * Returns this cid.
     *
     * @return cid.
     */
    public String getCid() {
        return cid;
    }

    /**
     * Returns boolean whether the password guess was correct or not.
     *
     * @param passwordGuess attempt to guess this password.
     * @return boolean whether the password guess was correct or not.
     */
    boolean isUserPassword(String passwordGuess) {
        return this.password.equals(passwordGuess);
    }


    /**
     * add reserved Book in hash map reservedBooks listing
     *
     * @param listing
     */
    void addReservedBook(Listing listing) {
        reservedBooks.add(listing);
    }

    /**
     * add a book which is for sale in the hashmap listing
     *
     * @param listing
     */
    void addListingForSale(Listing listing) {
        booksForSale.add(listing);
    }


    /**
     * add subscribed book in the hashmap list
     *
     * @param book
     */
    void addBookSubscription(Book book) {
        subscribedBooks.add(book);
    }

    /**
     * add previous purchased book in the hashmap list
     *
     * @param listing
     */
    void addPreviousPurchase(Listing listing) {
        previousPurchases.add(listing);
    }

    /**
     * Delete previous purchased book from the hashmap list
     *
     * @param listing
     */

    void removePreviousPurchase(Listing listing) {
        previousPurchases.remove(listing);
    }


    /**
     * Delete reserved book from the  list
     *
     * @param listing
     */
    void removeReservedBook(Listing listing) {
        reservedBooks.remove(listing);
    }

    /**
     * Delete the book for sale from the Array list
     *
     * @param listing
     */
    void removeListingForSale(Listing listing) {
        booksForSale.remove(listing);
    }


    /**
     * Delete subscribed book from the hashmap list
     *
     * @param bookCode book code
     */
    void removeBookSubscription(String bookCode) {
        subscribedBooks.removeIf(book -> book.getBookCode().equals(bookCode));
    }

    public List<Book> getSubscribedBooks() {
        return new ArrayList<>(subscribedBooks);
    }

    /**
     * @return
     */
    public List<Listing> getBooksForSale() {
        return new ArrayList<>(booksForSale);
    }

    public List<Listing> getReservedBooks() {
        return new ArrayList<>(reservedBooks);
    }

    public List<Listing> getPreviousPurchases() {
        return new ArrayList<>(previousPurchases);
    }

    void editListing(Listing listing) {
        for (Listing l : booksForSale) {
            if (l.getListingNumber() == listing.getListingNumber()) {
                booksForSale.set(booksForSale.indexOf(l), listing);
            }
        }
    }

    public List<Notification> getNotifications() {
        return new ArrayList<>(notifications);
    }
}
