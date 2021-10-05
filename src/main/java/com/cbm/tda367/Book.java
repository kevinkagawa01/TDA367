package com.cbm.tda367;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
/*

 */

/**
 * Represents a Book
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */

public class Book {

    private String bookName;
    private String bookAuthor;

    private final String bookCode;
    private int bookSales;

    private int bookSubscriptions;
    private String imagePath;


    /**
     * Constructs a Book
     *
     * @param bookName          The name of a Book as a String.
     * @param bookAuthor        The author of a Book as a String.
     * @param bookCode          The code (ISBN) of a Book as a String.
     * @param bookSales         The number of times a specific book has been sold, represented as an integer.
     * @param bookSubscriptions The number of current subscribers of a Book, represented as an integer.
     * @param imagePath         The path of a picture of a Book, represented as a String.
     * @param category          The category of a Book, represented as a String.
     */
    public Book(String bookName, String bookAuthor, String bookCode, int bookSales, int bookSubscriptions, String imagePath, String category) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCode = bookCode;
        this.bookSales = bookSales;
        this.bookSubscriptions = bookSubscriptions;
        this.imagePath = imagePath;

    }

    /**
     * Retrieves the name of a Book.
     *
     * @return The name of a Book, as a String.
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * Retrieves the name of the author of a Book.
     *
     * @return The name of the author of a Book, as a String.
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * Retrieves the code (ISBN) of a Book.
     *
     * @return The code (ISBN) of a Book, as a String.
     */
    public String getBookCode() {
        return bookCode;

    }

    /**
     * Retrieves the path of the picture of a Book.
     *
     * @return The path of the picture of a Book, as a String.
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Retrieves the number of times a book has been purchased.
     *
     * @return The number of times a book has been purchased, as an integer.
     */
    public int getBookSales() {
        return bookSales;
    }

    /**
     * Retrieves the number of current subscribers of a Book.
     *
     * @return The number of subscribers of a Book, as an integer.
     */
    public int getBookSubscriptions() {
        return bookSubscriptions;
    }


}
