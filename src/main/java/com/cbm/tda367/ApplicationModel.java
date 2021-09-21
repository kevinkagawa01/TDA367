package com.cbm.tda367;

import java.util.ArrayList;
import java.util.List;

public class ApplicationModel implements Observable{
    //TODO:
    // BookDatabase bookDatabase
    // UserDatabase userDatabase
    List<Listing> listings = new ArrayList<>();

    @Override
    public void notifyObservers() {

    }
}
