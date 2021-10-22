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

    private final String cid;
    private final String password;
    /* user lists */
    private final List<Notification> notifications;
    /* user assets */
    private final UserAsset<Book> subscribedBooks;
    private final UserAsset<Listing> reservedListings;
    private final UserAsset<Listing> previouslyTradedListings;
    private final UserAsset<Listing> publishedListings;
    private final UserRating userRating;

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
        this.notifications = new ArrayList<>();

        this.subscribedBooks = new UserAsset<>();
        this.reservedListings = new UserAsset<>();
        this.previouslyTradedListings = new UserAsset<>();
        this.publishedListings = new UserAsset<>();
    }

    private User(User user){
        this.cid = user.cid;
        this.password = user.password;
        this.userRating = user.userRating.cloneObject();
        /* safe copied lists */
        this.notifications = user.getNotifications();
        /* user assets */
        this.subscribedBooks = user.subscribedBooks.cloneObject();
        this.reservedListings = user.reservedListings.cloneObject();
        this.previouslyTradedListings = user.previouslyTradedListings.cloneObject();
        this.publishedListings = user.publishedListings.cloneObject();
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
        reservedListings.addListItem(listing);
    }

    /**
     * add a book which is for sale in the hashmap listing
     *
     * @param listing
     */
    void addListingForSale(Listing listing) {
        publishedListings.addListItem(listing);
    }


    /**
     * add subscribed book in the hashmap list
     *
     * @param book
     */
    void addBookSubscription(Book book) {
        subscribedBooks.addListItem(book);
    }

    /**
     * add previous purchased book in the hashmap list
     *
     * @param listing
     */
    void addPreviousPurchase(Listing listing) {
        previouslyTradedListings.addListItem(listing);
    }

    /**
     * Delete previous purchased book from the hashmap list
     *
     * @param listing
     */

    void removePreviousPurchase(Listing listing) {
        previouslyTradedListings.removeListItem(listing);
    }


    /**
     * Delete reserved book from the  list
     *
     * @param listing
     */
    void removeReservedBook(Listing listing) {
        reservedListings.removeListItem(listing);
    }

    /**
     * Delete the book for sale from the Array list
     *
     * @param listing
     */
    void removeListingForSale(Listing listing) {
        for(Listing l : publishedListings.getList()){
            if(l.getListingNumber() == listing.getListingNumber()){
                publishedListings.removeListItem(l);
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
        for(Book book : subscribedBooks.getList()){
            if(book.getBookCode().equals(bookCode)){
                subscribedBooks.removeListItem(book);
            }
        }
    }

    void receiveSubscribeNotification(String bookCode){
        for(Book b : subscribedBooks.getList()){
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

    void editListing(Listing listing) {
        for (Listing l : publishedListings.getList()) {
            if (l.getListingNumber() == listing.getListingNumber()) {
                publishedListings.setListItem(publishedListings.getList().indexOf(l), listing);
            }
        }
    }

    public List<Book> getSubscribedBooks() {
        return subscribedBooks.getList();
    }

    public List<Listing> getPublishedListings() {
        return publishedListings.getList();
    }

    public List<Notification> getNotifications() {
        return new ArrayList<>(notifications);
    }

    public List<Listing> getReservedListings() {
        return reservedListings.getList();
    }

    public List<Listing> getPreviouslyTradedListings() {
        return previouslyTradedListings.getList();
    }

    public UserRating getUserRating() {
        return userRating;
    }
}
