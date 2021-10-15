package com.cbm.tda367.model;

import java.util.ArrayList;
import java.util.List;
/** A database that stores "Users" objects
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 * */
public class UserDatabase {

    private final List<User> userList = new ArrayList<>();

    private final static UserDatabase userDatabase = new UserDatabase();

    private UserDatabase(){
        userList.add(new User("simonhol@student.chalmers.se", "hejsan123"));
        userList.add(new User("peg@student.chalmers.se", "peg123"));
        userList.add(new User("1","1"));
    }

    /**  Return the instance of the class through Singleton
     *
     * @return the instance of the userDataBase
     */
    static UserDatabase getInstance(){
        return userDatabase;
    }

    /** A getter for the userList
     *
     * @return a new arraylist of the userlist
     */
    List<User> getUserList(){
        return new ArrayList<>(userList);
    }
}
