package com.cbm.tda367.model;

import com.cbm.tda367.viewcontroller.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Application main class for the model containing the logic of the model.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 0.1
 */
public class ApplicationModel implements Observable {

    private final static ApplicationModel applicationModel = new ApplicationModel();

    private final BookDatabase bookDatabase;
    private final UserDatabase userDatabase;
    private final ListingDatabase listingDatabase;
    private User currentlyLoggedInUser = NotLoggedInUser.getInstance();
    //TODO: Should read current listing number from text file after initial launch
    private int currentListingNumber = 1;

    private List<Listing> listings = new ArrayList<>();
    private List<Observer> viewObservers = new ArrayList<>();

    /**
     * class constructor, private due to Singleton pattern implementation.
     */
    private ApplicationModel() {
        /* init databases */
        bookDatabase    = BookDatabase.getInstance();
        userDatabase    = UserDatabase.getInstance();
        listingDatabase = ListingDatabase.getInstance();
        /* Update views on start */
        notifyObservers();
    }

    /**
     * Returns single instance of this class.
     * @return single instance of this class.
     */
    public static ApplicationModel getInstance() {
        return applicationModel;
    }

    /**
     * implemented from interface Observable, notifying all observers that change has occured.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : viewObservers) {
            observer.update();
        }
    }

    /**
     * Adds an observer to the lists of observers, watching this class.
     * @param observer observes this class for changes.
     */
    @Override
    public void addObserver(Observer observer) {
        viewObservers.add(observer);
    }

    /**
     * Returns a list of the application's published listings.
     * @return a copied list of listings.
     */
    public List<Listing> getListingDatabase() {
        return listingDatabase.getListings();
    }

    /**
     * Removes a published listing from the application.
     * @param listing published listing to be removed.
     */
    private void removeListings(Listing listing) {
        listingDatabase.removeListing(listing);
    }

    private void editListing() {
    }

    /**
     * Adds a listing to the application.
     * @param bookCode book-code corresponding to the book the User wants to sell.
     * @param condition the listings condition.
     * @param price the listings price.
     */
    public void addListing(String bookCode, String condition, String price, String description) {
        /* Book corresponding with listing */
        Book book = bookDatabase.returnBookWithCorrespondingCode(bookCode);
        /* Creating new listing */
        Listing listing = new Listing(book, currentListingNumber++,
                Double.parseDouble(price),
                book.getImagePath(),
                condition,
                description,false,false);


       /* Add listing to listings */
        listingDatabase.addListing(listing);
        currentlyLoggedInUser.addListingForSale(listing);

         /* Update view */
        notifyObservers();
    }
    public void removedListingFromCurrentlyLoggedInUser(Listing listing) {
        /* Delete removed listing from Database */
        listingDatabase.removeListing(listing);

        /* Delete removed listing from user */
        currentlyLoggedInUser.removeListingForSale(listing);

        /* Update view */
        notifyObservers();
    }

    public void addBookToSubscriptionList(String  bookName, String image){
        Book book=bookDatabase.returnBookWithCorrespondingName(bookName);

        Book b=new Book(bookName,book.getBookAuthor(),book.getBookCode(),image,book.getCategory());

        /* add book to subscription list */
        currentlyLoggedInUser.addBookSubscription(b);
        /* Update view */
        notifyObservers();

    }
    public void removeBookFromSubscriptionList(Book book) {

        /* remove book from subscription list  */
        currentlyLoggedInUser.removeBookSubscription(book);
        /* Update view */
        notifyObservers();
    }
    public void reserveListing(Listing listing){
        currentlyLoggedInUser.addReservedBook(listing);
        /* Update view */
        notifyObservers();
    }
    public void removeBookFromReservedList(Listing listing) {

        /* remove book from subscription list  */
        currentlyLoggedInUser.removeReservedBook(listing);
        /* Update view */
        notifyObservers();
    }
    public void purchaseDone(Listing listing){
        currentlyLoggedInUser.addPreviousPurchase(listing);
        /* Update view */
        notifyObservers();

    }



   /* public List returnPopularbooks(List books) {
        //Todo: behöver gå igenom med gruppen
        List allBooks = BookDatabase.getInstance().getBookList();
        List popularBooks = new ArrayList();
        for (int i = 0; i < allBooks.size(); i++) {
            Book book = (Book) allBooks.get(i);
            Book book2 = (Book) allBooks.get(i++);

            if (book.getBookSales() < book2.getBookSales()) {
                popularBooks.add(book);
            }

        }

        return popularBooks;
    }*/
    public double getListingSellerRating(Listing listing){
        for(User user: userDatabase.getUserList()){
            for(Listing listing1 : user.getBooksForSale()){
                if (listing1.getListingNumber() == listing.getListingNumber()){
                    return user.getRating();
                }
            }
        }
        return -1;
    }

    public String getListingCid(Listing listing){
        for(User user: userDatabase.getUserList()){
            for(Listing listing1 : user.getBooksForSale()){
                if (listing1.getListingNumber() == listing.getListingNumber()){
                    return user.getCid();
                }
            }
        }
        return "";
    }


    /**
     * Determining whether login attempt was successful or not.
     * @param cid User chalmers identification.
     * @param password User password.
     * @return boolean whether the login attempt was successful or not.
     */
    public boolean isLoginSuccessful(String cid, String password) {
        for (User user : userDatabase.getUserList()) {
            if (user.getCid().equals(cid) && user.isUserPassword(password)) {
                currentlyLoggedInUser = user;
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the user that is currently logged in to the application.
     * @return the currently logged-in user.
     */
    public User getCurrentlyLoggedInUser() {
        return currentlyLoggedInUser;
    }

    public List<Book> getAllBooks() {
        return bookDatabase.getBookList();
    }

    public List<Book> filterBooksByName(String filter){
        /* Filtered books */
        List<Book> filteredBooks = new ArrayList<>();
        /* All books from database */
        List<Book> allBooks = bookDatabase.getBookList();

        for(Book book : allBooks){
            if(book.getBookName().toLowerCase().contains(filter.toLowerCase())){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }
}
