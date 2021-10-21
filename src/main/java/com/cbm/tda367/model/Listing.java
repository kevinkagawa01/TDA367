package com.cbm.tda367.model;

import java.time.LocalDate;

/**
 * Represents a listing
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */

public class Listing implements Prototype<Listing>{

    private final Book book;
    private final int listingNumber;
    private String condition;
    private String price;
    private final String imagePath;
    private String listingDescription;


    private boolean isReserved;
    private boolean isPurchased;
    private LocalDate date;

    /**
     * Constructs a listing
     *  @param book          A Book.
     * @param listingNumber An integer specifying a listing number.
     * @param price         A double specifying the cost of a listing.
     * @param imagePath     A String representing the path of an image.
     * @param condition     A String representing the condition of a Book.
     */

    Listing(Book book, int listingNumber, String price, String imagePath, String condition, String listingDescription, boolean isPurchased, boolean isReserved) {

        this.book = book;
        this.condition = condition;
        this.listingNumber = listingNumber;
        this.price = price;
        this.imagePath = imagePath;
        this.listingDescription = listingDescription;
        this.isReserved=isReserved;
        this.isPurchased=isPurchased;
        this.date = LocalDate.now();
    }

    Listing(Listing listing) {
        this.book = listing.book.cloneObject();
        this.condition = listing.condition;
        this.listingNumber = listing.listingNumber;
        this.price = listing.price;
        this.imagePath = listing.imagePath;
        this.listingDescription = listing.listingDescription;
        this.isReserved = listing.isReserved;
        this.isPurchased = listing.isPurchased;
        this.date = listing.date;
    }

    /**
     * Returns a safe copy of object.
     *
     * @return safe copy of object.
     */
    @Override
    public Listing cloneObject() {
        return new Listing(this);
    }

    public String getCondition(){
        return condition;
    }

    /**
     * Retrieves the Book of a specific Listing.
     *
     * @return A Book.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Retrieves the listing number of a specific Listing.
     *
     * @return A listing number.
     */
    public int getListingNumber() {
        return listingNumber;
    }

    /**
     * Retrieves the price of a specific listing.
     *
     * @return A price.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Retrieves the path of the picture of a specific listing.
     *
     * @return The path of a picture of a specific listing.
     */
    public String getImage() {
        return imagePath;
    }

    /**
     * Retrieves information regarding if a specific listing is reserved or not.
     *
     * @return A boolean regarding the reservation status of a specific Listing.
     */
    public boolean isReserved() {
        return isReserved;
    }



    //TODO: discuss with group (S)
    void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }

    /**
     * Retrieves information regarding if a specific listing has been purchased.
     *
     * @return A boolean regarding the purchase status of a specific listing.
     */
    public boolean isPurchased() {
        return isPurchased;
    }

    public LocalDate getDate(){
        return date;
     }

    public String getListingDescription() {
        return listingDescription;
    }

}
