module com.example.redactor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.redactor to javafx.fxml;
    exports com.example.redactor;
}