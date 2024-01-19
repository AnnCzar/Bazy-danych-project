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
        login.setOnAction(n -> logOption());
        register.setOnAction(n ->regOption());
        next.setOnAction(n -> nextOption());

        // Initialization code goes here
    }
}
