package com.cbm.tda367.model;

/** Interface implemented by an observable, notifying all of its observers when desired.
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 0.1
 * @since 0.1
 * */
public interface Observable {

    /** Notifies the implementers observers.
     * */
    void notifyObservers();

    /** Adds observer to implementer
     * */
    void addObserver(Observer observer);
}
