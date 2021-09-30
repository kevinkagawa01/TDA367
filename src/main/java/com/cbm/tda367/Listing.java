package com.cbm.tda367;

import javafx.scene.image.ImageView;

public class Listing {

    private final Book book;
    private final int listingNumber;

    private String condition;
    private final double price;
    private final ImageView image;

    private boolean isReserved;
    private boolean isCompleted;

    public Listing(Book book, int listingNumber, double price, ImageView image, String condition) {

        this.book = book;
        this.condition = condition;
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
