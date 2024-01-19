package org.example.demo5;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class logController implements Initializable {


    @FXML
    protected Button log;

    @FXML
    protected TextField login;

    @FXML
    protected Button next;

    @FXML
    protected Button register;

    @FXML
    protected Label us_name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.setOnAction(event -> logOption());
        register.setOnAction(event -> regOption());

        //next.setOnAction(event -> buttonAction());
    }
    @FXML
    public void logOption() {
        us_name.setVisible(true);
        login.setVisible(true);
        if (login.getText() != null && !login.getText().trim().isEmpty()) {
            next.setVisible(true);
            log.setVisible(false);
        } else {
            next.setVisible(false);
        }
    }
    @FXML
    public void regOption() {
        next.setVisible(true);
    }
}

//    public void acceptButton() {
//        if (log.isSelected()) {
//            us_name.setVisible(true);
////            login.setVisible(true);
//        } else if (login.getText() != null && !login.getText().trim().isEmpty()) {
//            next.setVisible(true);
//        } else {
//            next.setVisible(false);
//        }
//////        buttonAction();
//    }

//    public void buttonAction() {
//
//    }

