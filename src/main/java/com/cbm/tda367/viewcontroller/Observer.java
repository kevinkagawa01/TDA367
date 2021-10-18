package com.cbm.tda367.viewcontroller;

/**
 * Interface implemented by an observer, observing an observable implementing that corresponding interface.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 0.1
 * @since 0.1
 */
public interface Observer {

    /**
     * Updates this status.
     */
    void update();
}
