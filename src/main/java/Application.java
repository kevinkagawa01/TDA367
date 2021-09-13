import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ResourceBundle;

public class Application extends javafx.application.Application {

    public void start(Stage stage) throws Exception {

        ResourceBundle bundle = ResourceBundle.getBundle("CBM");

        Parent root = FXMLLoader.load(getClass().getResource("/cbm_main_anchorpane.fxml"), bundle);

        Scene scene = new Scene(root, 1000, 1000);
        stage.setTitle(bundle.getString("application.name"));
        stage.setScene(scene);
        stage.show();
    }
}
