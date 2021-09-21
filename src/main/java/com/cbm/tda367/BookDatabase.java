package com.cbm.tda367;

// Singelton pattern used in this class

import java.util.ArrayList;
import java.util.List;

public  class BookDatabase {

    private List<Book>bookList=new ArrayList<>();
    private static BookDatabase bookDatabase=new BookDatabase();



    private BookDatabase() {

    }

    public static BookDatabase getInstance(){
        return bookDatabase;

    }
}
