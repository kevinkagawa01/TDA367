package com.cbm.tda367;

// Singelton pattern used in this class

import java.util.ArrayList;
import java.util.List;

public  class BookDatabase {

    private List<Book>bookList=new ArrayList<>();
    private static BookDatabase bookDatabase = new BookDatabase();



    private BookDatabase() {

    }

    public static BookDatabase getInstance(){
        return bookDatabase;

    }
    public void addBook(Book book){
        bookList.add(book);

    }

    public boolean isBookCodeValid(String bookCode){
        for (Book book : bookList){
            if (book.getBookCode().equals(bookCode)){ return true; }
        }
        return false;
    }

    //TODO: refactor method
    public Book returnBookWithCorrespondingCode(String bookCode){
        for (Book book : bookList){
            if (book.getBookCode().equals(bookCode)){
                return book;
            }
        }
        //TODO: ajabaja
        return null;
    }

    public void removeBook(Book book){
        bookList.remove(book);
    }

    public List<Book> getBookList(){
        return new ArrayList<>(bookList);
    }

}
