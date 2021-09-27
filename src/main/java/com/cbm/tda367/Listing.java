package com.cbm.tda367;

import javafx.scene.image.ImageView;

public class Listing {

    private final Book book;
    private final int listingNumber;

    private final double price;
    private final ImageView image;

    private boolean isReserved;
    private boolean isCompleted;

    private enum bookCondition {
        NEW("New"), MINT("Mint"), MINIMAL_WEAR("Minimal Wear"),
        WELL_WORN("Well Worn"), DAMAGED("Damaged");

        private final String condition;

        bookCondition(String condition) {
            this.condition = condition;
        }

        public String getCondition() {
            return condition;
        }
    }

    public Listing(Book book, int listingNumber, double price, ImageView image, bookCondition condition) {
        this.book = book;
        this.listingNumber = listingNumber;
        this.price = price;
        this.image = image;

    }

    public Book getBook() {
        return book;
    }

    public int getListingNumber() {
        return listingNumber;
    }

    public double getPrice() {
        return price;
    }

    public ImageView getImage() {
        return image;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
