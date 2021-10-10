package com.cbm.tda367;
/** User sub-class representing an empty user when no user is currently logged in.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 * */
public class NotLoggedInUser extends User{

    private final static NotLoggedInUser notLoggedInUser = new NotLoggedInUser();

    /** the class create user
     */
    private NotLoggedInUser() {
        super("", "");
    }

    public static NotLoggedInUser getInstance(){
        return notLoggedInUser;
    }
}
