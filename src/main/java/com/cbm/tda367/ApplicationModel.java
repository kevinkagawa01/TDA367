package com.cbm.tda367;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplicationModel implements Observable {

    private static ApplicationModel applicationModel = new ApplicationModel();

    private BookDatabase bookDatabase;
    private UserDatabase userDatabase;
    //TODO: Shouldn't be null from start
    private User currentlyLoggedInUser;
    //TODO: Should read current listing number from text file after initial launch
    private int currentListingNumber = 0;
    private List<Listing> listings = new ArrayList<>();
    private List<Observer> viewObservers = new ArrayList<>();
    private HashMap<Integer,Listing> reservedBooks = new HashMap<>();

    private ApplicationModel() {
        /* init databases */
        bookDatabase = BookDatabase.getInstance();
        userDatabase = UserDatabase.getInstance();
        /* Update views on start */
        notifyObservers();
    }

    public static ApplicationModel getInstance() {
        return applicationModel;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : viewObservers) {
            observer.update();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        viewObservers.add(observer);
    }


    public List<Listing> getListings(Listing listing) {
        return new ArrayList<>(listings);
    }

    private void removeListings(Listing listing) {
        listings.remove(listing);
    }

    private void editListing() {
    }

    public void addListing(String bookCode, String condition, String price) {

        /* Book corresponding with listing */
        Book book = bookDatabase.returnBookWithCorrespondingCode(bookCode);

        /* Add listing to listings */
        listings.add(new Listing(book, currentListingNumber++,
                Double.parseDouble(price),
                book.getImagePath(),
                condition));

        /* Update view */
        notifyObservers();
    }

    public void setRatingPicture() {

        double rating = currentlyLoggedInUser.getRating() ;
        String sourcePathStar;
        if ((int)rating == 0) {
            sourcePathStar = "/Library/0stars.png";
        }
        if (rating > 0 || rating < 1) {
            sourcePathStar = "/Library/0-5stars.png";
        }
        if ((int)rating == 1) {
            sourcePathStar = "/Library/1-stars.png";
        }
        if (rating > 1 || rating < 2) {
            sourcePathStar = "/Library/1-5stars.png";
        }
        if ((int)rating==2) {
            sourcePathStar = "/Library/2-stars.png";
        }
        if (rating > 2 || rating < 3) {
            sourcePathStar = "/Library/2-5stars.png";
        }
        if ((int)rating == 3) {
            sourcePathStar = "/Library/3-stars.png";
        }
        if (rating > 3.5 || rating < 4) {
            sourcePathStar = "/Library/3-5stars.png";
        }
        if ((int)rating == 4) {
            sourcePathStar = "/Library/4-stars.png";
        }
        if (rating > 4 || rating < 5) {
            sourcePathStar = "/Library/4-5stars.png";
        }
        if ((int)rating == 5) {
            sourcePathStar = "/Library/5-stars.png";
        }
    }


    /*private List<Book> updateSearchResult(){

    }

     */
    public void populateBookListing() {

    }

    /*public List<Book>calcMostSubscribe(){

    }

     */
    public void reservedBook() {

    }
    /*
    public List returnPopularbooks(List books){
        List allBooks= BookDatabase.getInstance().getBookList();
        List popularBooks= new ArrayList();
        for(int i=0;i<allBooks.size();i++){


        }

        return allBooks;
    }*/


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
    public User getCurrentlyLoggedInUser(){
        return currentlyLoggedInUser;
    }

    public BookDatabase getBookDatabase() {
        return bookDatabase;
    }

    public UserDatabase getUserDatabase() {
        return userDatabase;
    }

}
