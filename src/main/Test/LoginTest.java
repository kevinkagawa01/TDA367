import com.cbm.tda367.model.ApplicationModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    private ApplicationModel model;

    @BeforeEach
    public void testSetUp() {
        model = ApplicationModel.getInstance();
    }
    @Test
    public void loginTest() {
        // Not sure what we should test here
    }
}
