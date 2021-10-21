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
final class EmptyUser extends User{

    private static EmptyUser emptyUser;

    /** the class create user
     */
    private EmptyUser() {
        super("", "");
    }

    static EmptyUser getInstance(){
        if(emptyUser == null) {
            emptyUser = new EmptyUser();
        }
        return emptyUser;
    }
}
