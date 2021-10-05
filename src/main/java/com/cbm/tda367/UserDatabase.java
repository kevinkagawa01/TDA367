package com.cbm.tda367;

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

    private List<User>userList=new ArrayList<>();

    private static UserDatabase userDatabase=new UserDatabase();



    private UserDatabase(){

    }

    /**  Return the instance of the class through Singleton
     *
     * @return the instance of the userDataBase
     */
    public static UserDatabase getInstance(){
        return userDatabase;
    }

    /** Adds a user to the userList
     *
     * @param user
     */
    public void addUser(User user){
        userList.add(user);
    }

    /** Removes a user to the userList
     *
     * @param user
     */
    public void removeUser(User user){
        userList.remove(user);
    }

    /** A getter for the userList
     *
     * @return a new arraylist of the userlist
     */
    public List<User> getUserList(){
        return new ArrayList<>(userList);
    }


}
