package com.cbm.tda367;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String cid;
    private double totalRating;
    private int sumOfRatings;
    private int nrRatings;
    //TODO: Change list types below to Listing/Book when those classes have been created
    private List<Object> reservedListings = new ArrayList<>();      // <-- Change to Listing
    private List<Object> listedBooks = new ArrayList<>();           // <-- Change to Listing
    private List<Object> subscribedBooks = new ArrayList<>();       // <-- Change to Book
    private List<Object> previousPurchases = new ArrayList<>();     // <-- Change to Listing
    private List<Object> notifications = new ArrayList<>();         // <-- Change to Notification


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
}
