package com.cbm.tda367.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an application user.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 0.3
 * @since 0.1
 */
public class User implements Prototype<User>{

    private String cid;
    private String password;
    /* user lists */
    private List<Listing> reservedBooks;
    private List<Listing> listingsForSale;
    private List<Book> subscribedBooks;
    private List<Listing> previousPurchases;
    private List<Notification> notifications;

    private UserRating userRating;

    /**
     * class constructor.
     *
     * @param cid      this chalmers identification.
     * @param password this password.
     */
    User(String cid, String password) {
        this.cid = cid;
        this.password = password;
        this.userRating = new UserRating(0,0,0);
        this.reservedBooks = new ArrayList<>();
        this.listingsForSale = new ArrayList<>();
        this.subscribedBooks = new ArrayList<>();
        this.previousPurchases = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    private User(User user){
        this.cid = user.cid;
        this.password = user.password;
        this.userRating = user.userRating.cloneObject();
        /* safe copied lists */
        this.reservedBooks = user.getReservedBooks();
        this.listingsForSale = user.getListingsForSale();
        this.subscribedBooks = user.getSubscribedBooks();
        this.previousPurchases = user.getPreviousPurchases();
        this.notifications = user.getNotifications();
    }

    /**
     * Returns a safe copy of object.
     * @return safe copy of object.
     */
    @Override
    public User cloneObject() {
        return new User(this);
    }

    /**
     * Returns this cid.
     *
     * @return cid.
     */
    public String getCid() {
        return cid;
    }

    /**
     * Returns boolean whether the password guess was correct or not.
     *
     * @param passwordGuess attempt to guess this password.
     * @return boolean whether the password guess was correct or not.
     */
    boolean isUserPassword(String passwordGuess) {
        return this.password.equals(passwordGuess);
    }


    /**
     * add reserved Book in hash map reservedBooks listing
     *
     * @param listing
     */
    void addReservedBook(Listing listing) {
        reservedBooks.add(listing);
    }

    /**
     * add a book which is for sale in the hashmap listing
     *
     * @param listing
     */
    void addListingForSale(Listing listing) {
        listingsForSale.add(listing.cloneObject());
    }


    /**
     * add subscribed book in the hashmap list
     *
     * @param book
     */
    void addBookSubscription(Book book) {
        subscribedBooks.add(book);
    }

    /**
     * add previous purchased book in the hashmap list
     *
     * @param listing
     */
    void addPreviousPurchase(Listing listing) {
        previousPurchases.add(listing);
    }

    /**
     * Delete previous purchased book from the hashmap list
     *
     * @param listing
     */

    void removePreviousPurchase(Listing listing) {
        previousPurchases.remove(listing);
    }


    /**
     * Delete reserved book from the  list
     *
     * @param listing
     */
    void removeReservedBook(Listing listing) {
        reservedBooks.remove(listing);
    }

    /**
     * Delete the book for sale from the Array list
     *
     * @param listing
     */
    void removeListingForSale(Listing listing) {
        for(Listing l : listingsForSale){
            if(l.getListingNumber() == listing.getListingNumber()){
                listingsForSale.remove(l);
                break;
            }
        }
    }


    /**
     * Delete subscribed book from the hashmap list
     *
     * @param bookCode book code
     */
    void removeBookSubscription(String bookCode) {
        subscribedBooks.removeIf(book -> book.getBookCode().equals(bookCode));
    }

    public boolean isSubscribedToBook(String bookCode){
        List<SubscribeNotification> subscribeNotifications = getSubscribeNotifications();

        for(SubscribeNotification notification : subscribeNotifications){
            if(notification.getBookCodeToRelatedBook().equals(bookCode)){
                return true;
            }
        }
        return false;
    }

    void receiveSubscribeNotification(String bookCode){
        for(Book b : subscribedBooks){
            if(b.getBookCode().equals(bookCode)){
                notifications.add(new SubscribeNotification(bookCode));
            }
        }
    }

    public List<SubscribeNotification> getSubscribeNotifications(){
        List<SubscribeNotification> subscribeNotifications = new ArrayList<>();
        for(Notification n : notifications){
            if(n.getClass().equals(SubscribeNotification.class)){
                subscribeNotifications.add((SubscribeNotification) n);
            }
        }
        return new ArrayList<>(subscribeNotifications);
    }

    void removeSubscribeNotification(String bookCode){
       List<SubscribeNotification> subscribeNotifications = getSubscribeNotifications();
       List<SubscribeNotification> notificationsToBeRemoved = new ArrayList<>();

        for(SubscribeNotification notification : subscribeNotifications){
            if(notification.getBookCodeToRelatedBook().equals(bookCode)){
                notificationsToBeRemoved.add(notification);
            }
        }
        notifications.removeAll(notificationsToBeRemoved);
    }

    public List<Book> getSubscribedBooks() {
        return new ArrayList<>(subscribedBooks);
    }

    /**
     * @return
     */
    public List<Listing> getListingsForSale() {
        return new ArrayList<>(listingsForSale);
    }

    public List<Listing> getReservedBooks() {
        return new ArrayList<>(reservedBooks);
    }

    public List<Listing> getPreviousPurchases() {
        return new ArrayList<>(previousPurchases);
    }

    void editListing(Listing listing) {
        for (Listing l : listingsForSale) {
            if (l.getListingNumber() == listing.getListingNumber()) {
                listingsForSale.set(listingsForSale.indexOf(l), listing);
            }
        }
    }

    public List<Notification> getNotifications() {
        return new ArrayList<>(notifications);
    }

    public UserRating getUserRating() {
        return userRating;
    }
}
