import com.cbm.tda367.ApplicationModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddListingsTest {
    private ApplicationModel model;

    @BeforeEach
    public void testSetUp() {
        model = ApplicationModel.getInstance();
    }
    @Test
    public void addListingTest(){
        assertTrue(model.getListingDatabase().isEmpty());
    }
}


