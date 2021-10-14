package com.cbm.tda367.model;

/**
 * Representing an abstract notification, purposed to have subclasses with specific notification messages.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 0.3
 * @since 0.1
 */
public abstract class Notification {

    private String notificationMessage;

    /**
     * Returns this notification message.
     *
     * @return this notification message.
     */
    public String getNotificationMessage() {
        return notificationMessage;
    }
}
