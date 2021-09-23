package com.cbm.tda367;

import java.util.ArrayList;
import java.util.List;

public class ListingDatabase {

    private List<Listing>listingList=new ArrayList<>();

    private static ListingDatabase listingDatabase = new ListingDatabase();

    private ListingDatabase(){

    }
    public static ListingDatabase getInstance() {
        return listingDatabase;
    }


    public void addListing(Listing listing){
        listingList.add(listing);
    }

    public void removeListing(Listing listing){
        listingList.remove(listing);

    }

    public List<Listing> getListings(){
        return new ArrayList<>(listingList);
    }



}
