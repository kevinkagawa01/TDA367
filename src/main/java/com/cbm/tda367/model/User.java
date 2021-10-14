package com.cbm.tda367.model;

import java.util.ArrayList;
import java.util.List;
/** Represents an application user.
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 0.3
 * @since 0.1
 * */
public class User {

    private String cid;
    private String password;
    private double totalRating;
    private int sumOfRatings;
    private int nrRatings;

    /* user lists */
    private final ArrayList<Listing> reservedBooks = new ArrayList<>();
    private final ArrayList<Listing> booksForSale = new ArrayList<>();
    private final ArrayList<Book> subscribedBooks = new ArrayList<>();
    private final ArrayList<Listing> previousPurchases = new ArrayList<>();
    private final List<Notification> notifications = new ArrayList<>();



    /** class constructor.
     @param cid this chalmers identification.
     @param password this password.
     */
    public User(String cid, String password) {
        this.cid = cid;
        this.password = password;
        this.totalRating = 0;
        this.sumOfRatings = 0;
        this.nrRatings = 0;
    }

    /**
     * adds users rating and updates the total
     * @param rating rating to be added to this total rating.
     */
    public void addRating(int rating) {
        /* if provided rating is invalid, return */
        if(!(0 <= rating && rating <= 5)) {return;}
        /* add rating to total sum of ratings */
        sumOfRatings += rating;
        /* increment number of raters */
        nrRatings++;
        /* round rating to one decimal place and split the total sum according to number of ratings */
        totalRating = round(((double) sumOfRatings / nrRatings),1);
    }

    /**
     * Returns this rating.
     * @return this rating.
     */
    public double getRating(){
        return totalRating;
    }

    /**
     * rounds a double to a certain precision
     * @param value double to be rounded.
     * @param precision precision to round the double according to.
     * @return rounded double.
     */
    private double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    /**
     * Returns this cid.
     * @return cid.
     */
    public String getCid() {
        return cid;
    }

    /**
     * Returns boolean whether the password guess was correct or not.
     * @param passwordGuess attempt to guess this password.
     * @return boolean whether the password guess was correct or not.
     */
    public boolean isUserPassword(String passwordGuess){
        //TODO: maybe make more secure
        return this.password.equals(passwordGuess);
    }



    /** add reserved Book in hash map reservedBooks listing
     * @param listing
     */
    public void addReservedBook(Listing listing){
        reservedBooks.add(listing);
    }

    /** add a book which is for sale in the hashmap listing
     * @param  listing
     *
     */
    public void addListingForSale(Listing listing){
        booksForSale.add(listing);
    }



    /** add subscribed book in the hashmap list
     * @param book
     *
     */
    public void addBookSubscription(Book book){
        subscribedBooks.add(book);
    }
    /** add previous purchased book in the hashmap list
     * @param listing
     *
     */
    public void addPreviousPurchase(Listing listing){
        previousPurchases.add(listing);
    }
    /** Delete previous purchased book from the hashmap list
     * @param listing
     */

    public void removePreviousPurchase(Listing listing){
        previousPurchases.remove(listing);
    }



    /** Delete reserved book from the  list
     * @param listing
     */
    public void removeReservedBook(Listing listing){
        reservedBooks.remove(listing);
    }

    /** Delete the book for sale from the Array list
     * @param listing
     */
    public void removeListingForSale(Listing listing){
        booksForSale.remove(listing);
    }


    /** Delete subscribed book from the hashmap list
     * @param book
     */
    public void removeBookSubscription(Book book){
        subscribedBooks.remove(book);
    }

    public ArrayList<Book> getSubscribedBooks() {
        return subscribedBooks;
    }
    /**
     *
     * @return
     */
    public ArrayList< Listing> getBooksForSale() {
        return booksForSale;
    }
    public ArrayList<Listing> getReservedBooks() { return reservedBooks;
    }
}
