package com.cbm.tda367;

import javafx.scene.image.ImageView;

public class Book {

    private String bookName;
    private String bookAuthor;

    private String bookCode;
    private int bookSales;

    private int bookSubscriptions;
    private ImageView image;

    private enum bookCategory{
        MATHEMATICS, PHYSICS, BIOLOGY,
        CHEMISTRY, PROGRAMMING, FICTION
    }
    public Book() {

    }
}
