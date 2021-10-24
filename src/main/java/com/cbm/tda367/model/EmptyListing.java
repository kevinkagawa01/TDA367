package com.cbm.tda367.model;

public final class EmptyListing extends Listing {


    /**
     * Constructs a listing
     *
     * @param book               A Book.
     * @param listingNumber      An integer specifying a listing number.
     * @param price              A double specifying the cost of a listing.
     * @param imagePath          A String representing the path of an image.
     * @param condition          A String representing the condition of a Book.
     * @param listingDescription
     * @param isPurchased
     * @param isReserved
     */
    private EmptyListing(Book book, int listingNumber, String price, String imagePath, String condition, String listingDescription, boolean isPurchased, boolean isReserved) {
        super(book, listingNumber, price, imagePath, condition, listingDescription, isPurchased, isReserved);
    }

    private EmptyListing(Listing listing) {
        super(listing);
    }

    private static EmptyListing emptyListing;

    /**
     * Returns singleton instance of this.
     *
     * @return singleton instance of this.
     */
    public static EmptyListing getInstance() {
        if (emptyListing == null) {
            emptyListing = new EmptyListing(EmptyBook.getInstance(), -1, "", "", "", "", false, false);

        }
        return emptyListing;
    }
}
