module com.cbm.tda367 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cbm.tda367 to javafx.fxml;
    exports com.cbm.tda367;
}