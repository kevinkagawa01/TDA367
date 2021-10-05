package com.cbm.tda367;

import javafx.scene.image.ImageView;

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

public class Listing {

    private final Book book;
    private final int listingNumber;

    private String condition;
    private final double price;
    private String imagePath;

    private boolean isReserved;
    private boolean isPurchased;

    /**
     * Constructs a listing
     *
     * @param book          A Book.
     * @param listingNumber An integer specifying a listing number.
     * @param price         A double specifying the cost of a listing.
     * @param imagePath     A String representing the path of an image.
     * @param condition     A String representing the condition of a Book.
     */

    public Listing(Book book, int listingNumber, double price, String imagePath, String condition) {

        this.book = book;
        this.condition = condition;
        this.listingNumber = listingNumber;
        this.price = price;
        this.imagePath = imagePath;
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
    public double getPrice() {
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

    /**
     * Retrieves information regarding if a specific listing has been purchased.
     *
     * @return A boolean regarding the purchase status of a specific listing.
     */
    public boolean isPurchased() {
        return isPurchased;
    }
}
