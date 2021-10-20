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

final class ListingDatabase {

    private final List<Listing> listingList = new ArrayList<>();


    private static ListingDatabase listingDatabase;

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
    static ListingDatabase getInstance() {
        if(listingDatabase == null) {
            listingDatabase = new ListingDatabase();
        }
        return listingDatabase;
    }

    /**
     * Adds a listing to the list of listing.
     *
     * @param listing An ArrayList of listings.
     */
    void addListing(Listing listing) {
        listingList.add(listing);
    }

    /**
     * Removes a listing from the list of listings.
     *
     * @param listing An ArrayList of listings.
     */
    void removeListing(Listing listing) {
        listingList.remove(listing);

    }

    void editListing(Listing listing) {
        for (Listing l : listingList) {
            if (l.getListingNumber() == listing.getListingNumber()) {
                listingList.set(listingList.indexOf(l), listing);
            }
        }
    }


    /**
     * Retrieves the list of listings.
     *
     * @return The list of listings.
     */
    List<Listing> getListings() {
        return new ArrayList<>(listingList);
    }


}
