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

    private  int which_next = 0;   // zmienna do sprawdzania któy przycisk został wcisniety


    @FXML
     public void logOption(ActionEvent event) {
//    public void logOption() {
        which_next = 0;
        us_name.setVisible(true);
        login.setVisible(true);
        next.setVisible(true);
        which_next = 1;  // wcisniecie logowania
    }

    @FXML
//    public void regOption() {
    public void regOption(ActionEvent event) {
        which_next = 0;
        us_name.setVisible(false);
        login.setVisible(false);
        next.setVisible(false);
        next.setVisible(true);
        which_next = 2;
    }
    @FXML
    public void nextPressed(ActionEvent event) {
        Stage stage = (Stage) log.getScene().getWindow();
        if (which_next == 1){
            try{
                String log =login.getText();
                if(log.equals("ania")){         // tutaj sprawdzenie czy jets w bazie
                    warn_login.setText("Nazwa użytkownika niepoprawna");
                }
                else{
                    //zapis do bazy
                    openMainApp(stage);

                }
            }catch(NullPointerException e) {
                e.printStackTrace();
            }

        }else if (which_next == 2){  //przejscie do okna nowy uzytkownik
            openMyApp(stage);
        }
    }
    @FXML
    private void openMainApp(Stage stage) {
        try {
            MainApp mainApp = new MainApp();
            mainApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
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
