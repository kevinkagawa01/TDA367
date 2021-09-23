package com.cbm.tda367;

import java.util.ArrayList;
import java.util.List;

public class ApplicationModel implements Observable{

     private BookDatabase bookDatabase;
     private UserDatabase userDatabase;

    List<Listing> listings = new ArrayList<>();
    List<Observer> viewObservers = new ArrayList<>();

    @Override
    public void notifyObservers() {
        for(Observer observer : viewObservers){
            observer.update();
        }
    }
    public void addListing(){

    }
    public List removeListings(){
        return listings;
    }
    public void editListing(){

    }

    public BookDatabase getBookDatabase(){
        return bookDatabase;
    }
    public UserDatabase getUserDatabase(){
        return userDatabase;
    }
}
