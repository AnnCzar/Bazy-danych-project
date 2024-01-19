package org.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class logController implements Initializable {

    @FXML
    protected Button next;

    @FXML
    protected Label us_name;

    @FXML
    protected TextField login;

    @FXML
    public void logOption(ActionEvent event) {
        us_name.setVisible(true);
        login.setVisible(true);
        next.setVisible(true);
    }

    @FXML
    public void regOption(ActionEvent event) {
        next.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code goes here
    }
}
