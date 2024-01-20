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
    protected Label warn_login;
    @FXML
    protected Button register;
    @FXML
    protected Button log;
    @FXML
    protected Button next;

    @FXML
    protected Label us_name;

    @FXML
    protected TextField login;
    
    @FXML
//     public void logOption(ActionEvent event) {

    public void logOption() {

        us_name.setVisible(true);
        login.setVisible(true);
        next.setVisible(true);
    }

    @FXML
    public void regOption() {
        us_name.setVisible(false);
        login.setVisible(false);
        next.setVisible(false);
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

    @FXML
    public  void nextOption(){
        try{
            String log =login.getText();
            if(log.equals("ania")){         // tutuaj sprawdzeenie czy jets w abzie

                warn_login.setText("Nazwa użytkownika zajęta");
            }
            else{
                //zapis do bazy


            }
        }catch(NullPointerException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//         next.setOnAction(this::nextPressed);
//         log.setOnAction(this :: logOption);
//         register.setOnAction(this::regOption);

        login.setOnAction(n -> logOption());
        register.setOnAction(n ->regOption());
        next.setOnAction(n -> nextOption());

        // Initialization code goes here

    }
}
