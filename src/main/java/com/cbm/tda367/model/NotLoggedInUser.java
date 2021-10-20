package com.cbm.tda367.model;
/** User sub-class representing an empty user when no user is currently logged in.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 * */
final class NotLoggedInUser extends User{

    private static NotLoggedInUser notLoggedInUser;

    /** the class create user
     */
    private NotLoggedInUser() {
        super("", "");
    }

    static NotLoggedInUser getInstance(){
        if(notLoggedInUser == null) {
            notLoggedInUser = new NotLoggedInUser();
        }
        return notLoggedInUser;
    }
}
