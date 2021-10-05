package com.cbm.tda367;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Book {

    private String bookName;
    private String bookAuthor;

    private final String bookCode;
    private int bookSales;

    private int bookSubscriptions;
    private String imagePath;




    public Book(String bookName, String bookAuthor, String bookCode, int bookSales, int bookSubscriptions, String imagePath, String category) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCode = bookCode;
        this.bookSales = bookSales;
        this.bookSubscriptions = bookSubscriptions;
        this.imagePath = imagePath;

    }


    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookCode() {
        return bookCode;

    }

    public String getImagePath() {
        return imagePath;
    }

    public int getBookSales() {
        return bookSales;
    }

    public int getBookSubscriptions() {
        return bookSubscriptions;
    }


}
