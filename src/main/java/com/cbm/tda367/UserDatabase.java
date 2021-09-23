package com.cbm.tda367;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {

    private List<User>userList=new ArrayList<>();
    private static UserDatabase userDatabase=new UserDatabase();



    private UserDatabase(){

    }

    public static UserDatabase getInstance(){
        return userDatabase;
    }

    public void addUser(User user){
        userList.add(user);

    }
    public void removeUser(User user){
        userList.remove(user);
    }


    public List<User> getUserList(){
        return new ArrayList<>(userList);
    }


}
