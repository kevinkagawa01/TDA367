package com.cbm.tda367.model;
/** Representing a notification, subclass from abstract notification, returning a message when user has subscribed to a book.
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 0.3
 * @since 0.1
 * */
public class SubscribeNotification extends Notification{

    private String bookCodeToRelatedBook;

    /**
     * Class constructor.
     * @param bookCode book code for the related type of notification.
     */
    public SubscribeNotification(String bookCode) {
        this.bookCodeToRelatedBook = bookCode;
    }

    /**
     * Returns related book code.
     * @return related book code.
     */
    public String getBookCodeToRelatedBook() {
        return bookCodeToRelatedBook;
    }
}
