module com.cbm.tda367 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cbm.tda367 to javafx.fxml;
    exports com.cbm.tda367;
    exports com.cbm.tda367.model;
    opens com.cbm.tda367.model to javafx.fxml;
    exports com.cbm.tda367.viewcontroller;
    opens com.cbm.tda367.viewcontroller to javafx.fxml;
}