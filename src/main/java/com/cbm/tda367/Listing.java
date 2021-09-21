package com.cbm.tda367;

import javafx.scene.image.ImageView;

public class Listing {

//    private Book book;
    private int listingNumber;

    private double price;
    private ImageView image;

    private boolean isReserved;
    private boolean isCompleted;

    private enum bookCondition {
        NEW, MINT, MINIMAL_WEAR,
        WELL_WORN, DAMAGED
    }

    public Listing(){

    }

}
