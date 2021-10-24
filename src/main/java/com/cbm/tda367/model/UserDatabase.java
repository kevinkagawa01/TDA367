package com.cbm.tda367.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A database that stores "Users" objects
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
final public class UserDatabase {

    private final List<User> userList = new ArrayList<>();

    private static UserDatabase userDatabase;

    private UserDatabase() {
        userList.add(new User("simonhol@student.chalmers.se", "hejsan123"));
        userList.add(new User("peg@student.chalmers.se", "peg123"));
        userList.add(new User("1", "1"));
    }

    /**
     * Return the instance of the class through Singleton
     *
     * @return the instance of the userDataBase
     */
    static UserDatabase getInstance() {
        if (userDatabase == null) {
            userDatabase = new UserDatabase();
        }
        return userDatabase;
    }

    void updateUser(User user) {
        for (User u : userList) {
            if (u.getCid().equals(user.getCid())) {
                userList.set(userList.indexOf(u), user.cloneObject());
            }
        }
    }


    /**
     * A getter for the userList
     *
     * @return a new arraylist of the userlist
     */
    List<User> getUserList() {
        return new ArrayList<>(userList);
    }
}
