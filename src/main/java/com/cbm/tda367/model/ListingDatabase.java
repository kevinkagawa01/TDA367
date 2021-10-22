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
        List<Book> allBooks= BookDatabase.getInstance().getBookList();
        addListing(new Listing(allBooks.get(0),1,"132",allBooks.get(0).getImagePath(),
                "New","hello",false,false ));
        addListing(new Listing(allBooks.get(1),2,"132",allBooks.get(1).getImagePath(),
                "New","hello",false,false ));
        addListing(new Listing(allBooks.get(2),3,"132",allBooks.get(2).getImagePath(),
                "New","hello",false,false ));
        addListing(new Listing(allBooks.get(3),4,"132",allBooks.get(3).getImagePath(),
                "New","hello",false,false ));
        addListing(new Listing(allBooks.get(4),4,"132",allBooks.get(4).getImagePath(),
                "New","hello",false,false ));
        addListing(new Listing(allBooks.get(5),5,"132",allBooks.get(5).getImagePath(),
                "New","hello",false,false ));

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
        listingList.add(listing.cloneObject());
    }

    /**
     * Removes a listing from the list of listings.
     *
     * @param listing An ArrayList of listings.
     */
    void removeListing(Listing listing) {
        for(Listing l : listingList){
            if(l.getListingNumber() == listing.getListingNumber()){
                listingList.remove(l);
                break;
            }
        }
    }

    void editListing(Listing listing) {
        for (Listing l : listingList) {
            if (l.getListingNumber() == listing.getListingNumber()) {
                listingList.set(listingList.indexOf(l), listing);
            }
        }
    }

    void reserveListing(Listing listing){
        for(Listing l: listingList){
            if(l.getListingNumber() ==  listing.getListingNumber()){
                l.setReserved(true);
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
