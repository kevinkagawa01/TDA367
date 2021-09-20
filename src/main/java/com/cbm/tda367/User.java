package com.cbm.tda367;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userCid;
    private double userTotalRating;
    private int sumOfRatings;
    private int nrRatings;
    //TODO: Change list types below to Listing/Book when those classes have been created
    private List<Object> userReservedListings = new ArrayList<>();      // <-- Change to Listing
    private List<Object> userListedBooks = new ArrayList<>();           // <-- Change to Listing
    private List<Object> userSubscribedBooks = new ArrayList<>();       // <-- Change to Book
    private List<Object> userPreviousPurchases = new ArrayList<>();     // <-- Change to Listing
    private List<Object> userNotifications = new ArrayList<>();         // <-- Change to Notification

    public void addRating(int rating) {
        /* if provided rating is invalid, return */
        if(!(0 <= rating && rating <= 5)) {return;}
        /* add rating to total sum of ratings */
        sumOfRatings += rating;
        /* split the total sum according to number of ratings */
        userTotalRating = ((double) sumOfRatings / nrRatings);
    }
}
