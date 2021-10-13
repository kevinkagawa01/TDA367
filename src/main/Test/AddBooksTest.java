import com.cbm.tda367.ApplicationModel;
import com.cbm.tda367.Book;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddBooksTest {
    public ApplicationModel model;

    @BeforeEach
    public void testSetUp() {
        model = ApplicationModel.getInstance();
    }
    @Test
    public void addBookTest(){

        assertFalse(model.getBookDatabase().getBookList().isEmpty());

        assertEquals(4,model.getBookDatabase().getBookList().size());
        model.getBookDatabase().removeBook(model.getBookDatabase().returnBookWithCorrespondingCode("TMA660"));
        assertEquals(3,model.getBookDatabase().getBookList().size());

        model.getBookDatabase().addBook(new Book("Linjär Algebra", //HAD TO ADD THIS BACK TO MAKE THE CURRENT LISTINGS TEST WORK...
                "Gunnar Sparr",
                "TMA660",
                "/book_covers/linalg.jpg",
                "Mathematics"));

    }
}
