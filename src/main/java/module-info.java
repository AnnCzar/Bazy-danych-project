module Test {
    requires  javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.demo5;
    requires jakarta.persistence;


    opens org.example.demo5 to javafx.fxml;
    exports org.example.demo5;


}