package com.cbm.tda367;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {

    private String cid;
    private double totalRating;
    private int sumOfRatings;
    private int nrRatings;

    /* user lists */
    private HashMap<Integer,Listing> reservedBooks = new HashMap<>();
    private HashMap<Integer,Listing> booksForSale = new HashMap<>();
    private HashMap<String,Book> subscribedBooks = new HashMap<>();
    private HashMap<Integer,Listing> previousPurchases = new HashMap<>();
    private List<Notification> notifications = new ArrayList<>();

    /* adds users rating and updates the total */
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

    /* used to round doubles to a certain precision */
    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public void addReservedBook(Listing listing){
        reservedBooks.put(listing.getListingNumber(),listing);
    }

    public void addListingForSale(Listing listing){
        booksForSale.put(listing.getListingNumber(), listing);
    }

    public void addBookSubscription(Book book){
        subscribedBooks.put(book.getBookCode(),book);
    }

    public void addPreviousPurchase(Listing listing){
        previousPurchases.put(listing.getListingNumber(),listing);
    }

    public void removePreviousPurchase(Integer listingNr){
        previousPurchases.remove(listingNr);
    }

    public void removeReservedBook(Integer listingNr){
        reservedBooks.remove(listingNr);
    }

    public void removeListingForSale(Integer listingNr){
        booksForSale.remove(listingNr);
    }

    public void removeBookSubscription(String bookCode){
        subscribedBooks.remove(bookCode);
    }
}
