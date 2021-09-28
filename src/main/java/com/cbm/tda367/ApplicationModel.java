package com.cbm.tda367;

import java.util.ArrayList;
import java.util.List;

public class ApplicationModel implements Observable{

     private BookDatabase bookDatabase;
     private UserDatabase userDatabase;
     private User currentlyLoggedInUser;

    List<Listing> listings = new ArrayList<>();
    List<Observer> viewObservers = new ArrayList<>();

    @Override
    public void notifyObservers() {
        for(Observer observer : viewObservers){
            observer.update();
        }
    }

    private List<Listing> addListing(Listing listing){
       return new ArrayList<>(listings);
    }
    private void removeListings(Listing listing){
        listings.remove(listing);
    }

    private void editListing(){
       

    }
    /*private List<Book> updateSearchResult(){

    }

     */
    public void populateBookListing(){

    }
    /*public List<Book>calcMostSubscribe(){

    }

     */
    public void reservedBook(){

    }

    public boolean isLoginSuccessful(String cid, String password){
        for (User user : userDatabase.getUserList()){
            if (user.getCid().equals(cid) && user.isUserPassword(password)){
                currentlyLoggedInUser = user;
                return true;
            }
        }
        return false;
    }

    public BookDatabase getBookDatabase(){
        return bookDatabase;
    }
    public UserDatabase getUserDatabase(){
        return userDatabase;
    }

}
