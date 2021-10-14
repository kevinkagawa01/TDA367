package com.cbm.tda367.viewcontroller;

import javafx.event.Event;

/**
 * An interface defining methods for global navigation controls.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */

public interface GlobalMenu {

    /**
     * A method defining shop button behavior.
     *
     * @param event An Event
     */
    void shopButton(Event event);

    /**
     * A method defining account button behavior.
     *
     * @param event An Event.
     */

    void accountButton(Event event);

    /**
     * A method defining add button (to add a listing) behavior.
     *
     * @param event An Event.
     */
    void addButton(Event event);


}
