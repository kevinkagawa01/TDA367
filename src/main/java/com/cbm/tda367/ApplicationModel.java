package com.cbm.tda367;

import java.util.ArrayList;
import java.util.List;

public class ApplicationModel implements Observable{

    private static ApplicationModel applicationModel = new ApplicationModel();

     private BookDatabase bookDatabase;
     private UserDatabase userDatabase;
     //TODO: Shouldn't be null from start
     private User currentlyLoggedInUser;

    List<Listing> listings = new ArrayList<>();
    List<Observer> viewObservers = new ArrayList<>();

    private ApplicationModel() {
        /* init databases */
        bookDatabase = BookDatabase.getInstance();
        userDatabase = UserDatabase.getInstance();

        /* add mock-users */
        userDatabase.addUser(new User("simonhol@student.chalmers.se","hejsan123"));
        userDatabase.addUser(new User("1","1"));
    }

    public static ApplicationModel getInstance(){
        return applicationModel;
    }

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
