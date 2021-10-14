package com.cbm.tda367.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the database of listings
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */

public class ListingDatabase {

    private final List<Listing> listingList = new ArrayList<>();


    private final static ListingDatabase listingDatabase = new ListingDatabase();

    /**
     * Constructs the Listing database singleton.
     */
    private ListingDatabase() {

    }

    /**
     * Getter for the Listing database singleton.
     *
     * @return The listing database instance.
     */
    public static ListingDatabase getInstance() {
        return listingDatabase;
    }

    /**
     * Adds a listing to the list of listing.
     *
     * @param listing An ArrayList of listings.
     */
    public void addListing(Listing listing) {
        listingList.add(listing);
    }

    /**
     * Removes a listing from the list of listings.
     *
     * @param listing An ArrayList of listings.
     */
    public void removeListing(Listing listing) {
        listingList.remove(listing);

    }

    /**
     * Retrieves the list of listings.
     *
     * @return The list of listings.
     */
    public List<Listing> getListings() {
        return new ArrayList<>(listingList);
    }


}
