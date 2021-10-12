import com.cbm.tda367.ApplicationModel;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AddBooksTest {
    public ApplicationModel model;

    @BeforeEach
    public void testSetUp() {
        model = ApplicationModel.getInstance();
    }
    @Test
    public void addBookTest(){
        assertFalse(model.getBookDatabase().getBookList().isEmpty());
    }
}
