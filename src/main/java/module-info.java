module com.example.redactor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.redactor to javafx.fxml;
    exports com.example.redactor;
}