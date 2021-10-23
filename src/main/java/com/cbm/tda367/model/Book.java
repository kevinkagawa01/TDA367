package com.cbm.tda367.model;



import java.time.LocalDate;
import java.util.Objects;


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

public class Book implements Prototype<Book>{

    private final String bookName;
    private final String bookAuthor;
    private final String bookCode;
    private int bookSales;
    private int bookSubscriptions;
    private final String imagePath;
    private final String category;


    private LocalDate date = LocalDate.now();


    /**
     * Constructs a Book
     *
     * @param bookName          The name of a Book as a String.
     * @param bookAuthor        The author of a Book as a String.
     * @param bookCode          The code (ISBN) of a Book as a String.
     * @param imagePath         The path of a picture of a Book, represented as a String.
     * @param category          The category of a Book, represented as a String.
     */
    Book(String bookName, String bookAuthor, String bookCode, String imagePath,String category) {
        this.bookName = Objects.requireNonNull(bookName);
        this.bookAuthor = Objects.requireNonNull(bookAuthor);
        this.bookCode = Objects.requireNonNull(bookCode);
        this.imagePath = Objects.requireNonNull(imagePath);
        this.bookSales = 0;
        this.bookSubscriptions = 0;
        this.category = category;
    }

    Book(Book book){
        this.bookName = book.bookName;
        this.bookAuthor = book.bookAuthor;
        this.bookCode = book.bookCode;
        this.imagePath = book.imagePath;
        this.bookSales = book.bookSales;
        this.bookSubscriptions = book.bookSubscriptions;
        this.category = book.category;
        this.date = book.date;
    }

    /**
     * Returns a safe copy of object.
     * @return safe copy of object.
     */
    @Override
    public Book cloneObject() {
        return new Book(this);
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

    /**
     * Increments number of book's subscribers.
     */
    void incrementSubscriptions(){
        bookSubscriptions++;
    }

    /**
     * Decrements number of book's subscribers.
     */
    void decrementSubscription(){
        bookSubscriptions--;
    }

    /**
     * Returns book date.
     * @return book date.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns book category.
     * @return book category.
     */
    public String getCategory() {
        return category;
    }

}
