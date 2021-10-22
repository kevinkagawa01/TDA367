import com.cbm.tda367.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListingsTest {
    private ApplicationModel model;


    @BeforeEach
    public void testSetUp() {
        model = ApplicationModel.getInstance();


    }

    @Test
    public void removeReservedListingTest() {
        List<Listing> listingDatabase = model.getListingDatabase();
        model.removeBookFromReservedList(listingDatabase.get(1));
        assertEquals(model.getListingDatabase().size(), 5);
    }

    @Test
    public void getListingSellerRatingTest() {
        List<Listing> listingDatabase = model.getListingDatabase();
        assertEquals(model.getListingSellerRating(listingDatabase.get(0)), -1);
    }

    @Test
    public void getAllBooksTest() {
        List<Book> allbooks = model.getAllBooks();
        assertEquals(allbooks.size(), 9);
    }


    @Test
    public void addListingTest() {
        model.addListing("TMA660", "New", "300", "Test");
        assertEquals(model.getListingDatabase().size(), 6);
    }


}


