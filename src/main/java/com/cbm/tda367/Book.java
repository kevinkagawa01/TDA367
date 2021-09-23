package com.cbm.tda367;

import javafx.scene.image.ImageView;

public class Book {

    private String bookName;
    private String bookAuthor;

    private final String bookCode;
    private int bookSales;

    private int bookSubscriptions;
    private ImageView image;


    private enum bookCategory {
        MATHEMATICS, PHYSICS, BIOLOGY,
        CHEMISTRY, PROGRAMMING, FICTION;
    }


    private String bookCategory;


    public Book(String bookName, String bookAuthor, String bookCode, int bookSales, int bookSubscriptions, ImageView image,bookCategory categori) {
        this.bookName=bookName;
        this.bookAuthor=bookAuthor;
        this.bookCode=bookCode;
        this.bookSales=bookSales;
        this.bookSubscriptions=bookSubscriptions;
        this.image=image;

    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor(){
        return bookAuthor;
    }
    public String getBookCode(){
        return bookCode;

    }
    public ImageView getImage(){
        return image;
    }

    public int getBookSales() {
        return bookSales;
    }

    public int getBookSubscriptions() {
        return bookSubscriptions;
    }

}
