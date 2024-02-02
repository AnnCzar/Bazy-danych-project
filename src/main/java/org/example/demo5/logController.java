
package org.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class logController implements Initializable{
    /**
     * Controller class for the login view.
     */
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
        /**
         * Handles the action when the login button is pressed.
         * Sets up the view for logging in.
         *
         * @param event The ActionEvent triggered by the button press.
         */
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
        /**
         * Handles the action when the register button is pressed.
         * Sets up the view for user registration.
         *
         * @param event The ActionEvent triggered by the button press.
         */
        which_next = 0;
        us_name.setVisible(false);
        login.setVisible(false);
        next.setVisible(false);
        next.setVisible(true);
        which_next = 2;
    }

    @FXML
    public String getUserName(){
        /**
         * Gets the entered username from the text field.
         *
         * @return The entered username as a String.
         */
        return login.getText();
    }
    @FXML
    public void nextPressed(ActionEvent event) {
        /**
         * Handles the action when the next button is pressed.
         * Performs either login or registration based on the current view.
         *
         * @param event The ActionEvent triggered by the button press.
         */
        warn_login.setVisible(false);
        Stage stage = (Stage) log.getScene().getWindow();
        if (which_next == 1){
            try{
                String log =login.getText();
//                List<String> username = new ArrayList<>();
                List<String> usernames = readUsernamesFromCSV("C:\\Users\\Ania\\Repositories\\ZPO-project\\uzytkownicy.csv");
                // username = // FUNKCJA SCIAGNIECIE NAZW UZYTKOWNIKOW Z BAZY 'USERS'

                // SPRAWDZENIE DZIALANIA - USUNAC JEZELI ZOSTANIE PODLACZONA FUNKCJA
//                username.add("a");
//                username.add("ania");
//                username.add("as");

                if(usernames.contains(log)){
                    openMainApp(stage);
                    // PRZYPISAANIE ZMIENNEJ NAZWY UZYTKOWNIKA - PRZEKAZANIE DO KOLEJNEGO OKNA
                }
                else{
                    throw new InvalidUsernameException("Nazwa użytkownika niepoprawna");


                }
            }catch(InvalidUsernameException e){
                warn_login.setVisible(true);
                warn_login.setText("Nazwa użytkownika niepoprawna");
            }

            catch(NullPointerException e) {
                e.printStackTrace();
            }

        }else if (which_next == 2){  //PRZEJSCIE DO OKNA DZIENNE SPOZYCIE
            openMyApp(stage);
        }
    }

    @FXML
    private void openMainApp(Stage stage) {
        /**
         * Opens the main application window.
         *
         * @param stage The Stage to show the main application window.
         */

        // PROBA PRZEKAZANIA NAZWY UZYTKOWNIKA
        MainAppController mainAppController = new MainAppController(this);
        mainAppController.showStage();
//            MainApp mainApp = new MainApp();
//            mainApp.start(stage);
    }

    @FXML
    private void openMyApp(Stage stage) {
        /**
         * Opens the user registration window.
         *
         * @param stage The Stage to show the user registration window.
         */
        try {
            MyApp myApp = new MyApp();
            myApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readUsernamesFromCSV(String filePath) {
        /**
         * Reads usernames from a CSV file.
         *
         * @param filePath The path to the CSV file.
         * @return List of usernames read from the CSV file.
         */
        List<String> usernames = new ArrayList<>();

//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                // Assuming that usernames are in the first column, you may need to adjust accordingly
//                String[] columns = line.split(",");
//                usernames.add(columns[0].trim());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            usernames = br.lines()
                    .map(line -> line.split(",")[0].trim())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usernames;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         next.setOnAction(this::nextPressed);
         log.setOnAction(this :: logOption);
         register.setOnAction(this::regOption);


    }
}

