package org.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
    protected Button register;

    @FXML
    protected Button log;
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
    @FXML
    public void nextPressed(ActionEvent event) {
        Stage stage = (Stage) log.getScene().getWindow();
        if (event.getSource() == log) {
            openMainApp(stage);
        } else {
            openMyApp(stage);
        }
    }

    private void openMainApp(Stage stage) {
        try {
            MainApp mainApp = new MainApp();
            mainApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openMyApp(Stage stage) {
        try {
            MyApp myApp = new MyApp();
            myApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        next.setOnAction(this::nextPressed);
        log.setOnAction(this :: logOption);
        register.setOnAction(this::regOption);
    }
}
