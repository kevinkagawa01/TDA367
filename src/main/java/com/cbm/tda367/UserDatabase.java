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

}
