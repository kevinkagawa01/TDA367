package com.cbm.tda367;


import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the database of Books
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */

public class BookDatabase {

    private List<Book> bookList = new ArrayList<>();
    private static BookDatabase bookDatabase = new BookDatabase();

    /**
     * Constructs the Book database singleton.
     */
    private BookDatabase() {

        Book korv = new Book("mårtan", "123", "0", 0, 0, "src/main/resources/Library/bookSample.png", "Fiction");
        //Kan ej hitt url samt har problem med att ENUM inparametern

        // Book korv = new Book("mårtan", "123", "0", 0, 0, new Image("src/main/resources/Library/bookSample.png"), "Fiction");
        //Kan ej hitt url samt har problem med att ENUM inparametern

    }

    /**
     * Retrieves the Book database singleton.
     *
     * @return The BookDatabase instance.
     */
    public static BookDatabase getInstance() {
        return bookDatabase;

    }

    /**
     * Adds a Book to the list of Books.
     *
     * @param book A Book.
     */
    public void addBook(Book book) {
        bookList.add(book);
    }

    /**
     * Retrieves the Book corresponding to a specific Book code (ISBN)
     *
     * @param bookCode A Book code (ISBN), as an integer.
     * @return A Book corresponding to a specific Book code (ISBN).
     */
    //TODO: refactor method
    public Book returnBookWithCorrespondingCode(String bookCode) {
        for (Book book : bookList) {
            if (book.getBookCode().equals(bookCode)) {
                return book;
            }
        }
        //TODO: can currently return null
        return null;
    }

    /**
     * Removes a Book from the list of Books.
     *
     * @param book A Book.
     */
    public void removeBook(Book book) {
        bookList.remove(book);
    }

    /**
     * Retrieves the list of Books.
     *
     * @return An ArrayList of Books.
     */
    public List<Book> getBookList() {
        return new ArrayList<>(bookList);
    }

}
