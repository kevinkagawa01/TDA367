package com.cbm.tda367.model;

public final class EmptyBook extends Book{

    /**
     * Constructs a Book
     *
     * @param bookName   The name of a Book as a String.
     * @param bookAuthor The author of a Book as a String.
     * @param bookCode   The code (ISBN) of a Book as a String.
     * @param imagePath  The path of a picture of a Book, represented as a String.
     * @param category   The category of a Book, represented as a String.
     */
    private EmptyBook(String bookName, String bookAuthor, String bookCode, String imagePath, String category) {
        super(bookName, bookAuthor, bookCode, imagePath, category);
    }

    private EmptyBook(Book book) {
        super(book);
    }

    private static EmptyBook emptyBook;

    public static EmptyBook getInstance() {
        if (emptyBook == null) {
            emptyBook = new EmptyBook("","","","","");
        } return emptyBook;
    }
}
