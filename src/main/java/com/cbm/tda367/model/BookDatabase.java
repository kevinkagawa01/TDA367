package com.cbm.tda367.model;


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

final class BookDatabase {

    private final List<Book> bookList = new ArrayList<>();
    private static BookDatabase bookDatabase;

    /**
     * Constructs the Book database singleton.
     */
    private BookDatabase() {

        bookList.add(new Book("Linjär Algebra",
                "Gunnar Sparr",
                "TMA660",
                "/book_covers/linalg.jpg",
                "Mathematics"));

        bookList.add(new Book("Diskret Matematik",
                "Stefan Lemurell",
                "TMV210",
                "/book_covers/diskret_matematik.jpg",
                "Mathematics"));

        bookList.add(new Book("Grundläggande Datorteknik",
                "Roger Johansson",
                "EDA433",
                "/book_covers/grudat.jpg",
                "Programming"));

        bookList.add(new Book("Calculus: A Complete Course",
                "Robert Adams",
                "MVE045",
                "/book_covers/calculus.jpg",
                "Mathematics"));

        bookList.add(new Book("Maskinorienterad programmering",
                "Roger Johansson",
                "MD407",
                "/book_covers/mop.jpg",
                "Programming"));

        bookList.add(new Book("Parallel Programming",
                "Thomas Rauber",
                "PARALLELPROGRAMMING",
                "/book_covers/parallel_programming.jpg",
                "Programming"));

        bookList.add(new Book("Python Programming",
                "John Zelle",
                "PYTHONPROGRAMMING",
                "/book_covers/python_programming.jpg",
                "Programming"));

        bookList.add(new Book("The C Programming Language",
                "Brian W. Kernighan",
                "CPROGRAMMING",
                "/book_covers/c_programming.jpg",
                "Programming"));

        bookList.add(new Book("Agile!",
                "Bertrand Meyer",
                "EDA397",
                "/book_covers/agile.jpg",
                "Programming"));
    }

    /**
     * Retrieves the Book database singleton.
     *
     * @return The BookDatabase instance.
     */
    static BookDatabase getInstance() {
        if (bookDatabase == null) {
            bookDatabase = new BookDatabase();
        }
        return bookDatabase;

    }

    /**
     * Adds a Book to the list of Books.
     *
     * @param book A Book.
     */
    void addBook(Book book) {
        bookList.add(book.cloneObject());
    }

    /**
     * increments number of subscribers to book, corresponding to the book code.
     *
     * @param bookCode book's subscribers to be incremented.
     */
    void incrementSubscription(String bookCode) {
        for (Book book : bookList) {
            if (book.getBookCode().equals(bookCode)) {
                book.incrementSubscriptions();
            }
        }
    }

    /**
     * decrements number of subscribers to book, corresponding to the book code.
     *
     * @param bookCode book's subscribers to be decremented.
     */
    void decrementSubscription(String bookCode) {
        for (Book book : bookList) {
            if (book.getBookCode().equals(bookCode)) {
                book.decrementSubscription();
            }
        }
    }

    /**
     * Removes a Book from the list of Books.
     *
     * @param book A Book.
     */
    void removeBook(Book book) {
        bookList.remove(book);
    }

    /**
     * Retrieves the list of Books.
     *
     * @return An ArrayList of Books.
     */
    List<Book> getBookList() {
        return new ArrayList<>(bookList);
    }

}
