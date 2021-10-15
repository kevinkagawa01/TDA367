import com.cbm.tda367.model.ApplicationModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddListingsTest {
    private ApplicationModel model;

    @BeforeEach
    public void testSetUp() {
        model = ApplicationModel.getInstance();
    }
    @Test
    public void addListingTest(){
        assertTrue(model.getListingDatabase().isEmpty());

        model.addListing("TMA660", "New", "300", "Test");
        assertFalse(model.getListingDatabase().isEmpty());

        assertEquals(1, model.getListingDatabase().size());

        assertEquals(0,model.getListingDatabase().get(0).getListingNumber()); // FIRST LISTING DOES NOT GET LISTING NUMBER 1. FIX IN APPLICATION MODEL

        model.addListing("TMA660", "New", "300", "Test2");

        assertEquals(1,model.getListingDatabase().get(1).getListingNumber());
    }
}


