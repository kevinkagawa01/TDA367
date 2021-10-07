package com.cbm.tda367;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/** the class create user
@param
 */


/**
 * Represents the database of Books
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */

public class User {

    private String cid;
    private String password;
    private double totalRating;
    private int sumOfRatings;
    private int nrRatings;

    /* user lists */
    private HashMap<Integer,Listing> reservedBooks = new HashMap<>();
    private HashMap<Integer,Listing> booksForSale = new HashMap<>();
    private HashMap<String,Book> subscribedBooks = new HashMap<>();
    private HashMap<Integer,Listing> previousPurchases = new HashMap<>();
    private List<Notification> notifications = new ArrayList<>();


    /** the class create user
     @param
     */




    public User(String cid, String password) {
        this.cid = cid;
        this.password = password;
        this.totalRating = 0;
        this.sumOfRatings = 0;
        this.nrRatings = 0;
    }

    /**
    @param
    @ adds users rating and updates the total
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

    public double getRating(){
        return totalRating;
    }
    /**
     * @param
    @ used to round doubles to a certain precision */

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public String getCid() {
        return cid;
    }

    /** return password
     * @param passwordGuess
     * @return users password
     */

    public boolean isUserPassword(String passwordGuess){
        //TODO: maybe make more secure
        return this.password.equals(passwordGuess);
    }

    /** add reserved Book in hash map reservedBooks listing
     * @param listing
     */
    public void addReservedBook(Listing listing){
        reservedBooks.put(listing.getListingNumber(),listing);
    }

    /** add a book which is for sale in the hashmap listing
     * @param  listing
     *
     */
    public void addListingForSale(Listing listing){
        booksForSale.put(listing.getListingNumber(), listing);
    }

    /** add subscribed book in the hashmap list
     * @param book
     *
     */
    public void addBookSubscription(Book book){
        subscribedBooks.put(book.getBookCode(),book);
    }
    /** add previous purchased book in the hashmap list
     * @param listing
     *
     */
    public void addPreviousPurchase(Listing listing){
        previousPurchases.put(listing.getListingNumber(),listing);
    }
    /** Delete previous purchased book from the hashmap list
     * @param listingNr
     */

    public void removePreviousPurchase(Integer listingNr){
        previousPurchases.remove(listingNr);
    }

    /** Delete reserved book from the hashmap list
     * @param listingNr
     */
    public void removeReservedBook(Integer listingNr){
        reservedBooks.remove(listingNr);
    }

    /** Delete the book for sale from the hashmap list
     * @param listingNr
     */
    public void removeListingForSale(Integer listingNr){
        booksForSale.remove(listingNr);
    }


    /** Delete subscribed book from the hashmap list
     * @param bookCode
     */
    public void removeBookSubscription(String bookCode){
        subscribedBooks.remove(bookCode);
    }
}
