package org.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class newgoalController implements Initializable {
    @FXML
    public Label warning;
    @FXML
    private Button confirm_button;
    @FXML
    private ChoiceBox<String> goal;
    @FXML
    private ChoiceBox<String> activity;
    @FXML
    private TextField weight;
    private String[] activity1 = {
            "brak (osoba chora, leżąca w łóżku)",
            "mała (osoba wykonująca pracę siedzącą)",
            "umiarkowana (osoba wykonująca pracę na stojąco)",
            "duża (osoba prowadząca aktywny tryb życia, regularnie ćwicząca)",
            "bardzo duża (osoba prowadząca bardzo aktywny tryb życia, codziennie ćwicząca)",
            "osoba zawodowo uprawiająca sport"
    };
    private String[] goals = {
            "schudnąć",
            "utrzymać wagę",
            "przytyć"
    };

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         *
         */
        if (activity != null) {
            activity.getItems().addAll(activity1);
        }
        goal.getItems().addAll(goals);

    }
    @FXML
    public String getActivity(ActionEvent event) {
        /**
         *
         */
        String selectedActivity = activity.getValue();
        if (selectedActivity == null){
            throw new IllegalArgumentException("Not selected ");
        }
        return selectedActivity;
    }
    @FXML
    public String getGoal(ActionEvent ev) {
        /**
         *
         */
        String selectedGoal = goal.getValue();
        if(selectedGoal == null){
            throw  new IllegalArgumentException("Not selected");
        }
        return selectedGoal;
    }
    @FXML
    public double getWeight(ActionEvent event) {
        /**
         *
         */
        double weight1 = Double.parseDouble(weight.getText());
        if (weight1 <= 0){
            throw new IllegalArgumentException("Weight can not be under 0");
        }
        return weight1;
    }

    @FXML
    public void buttonConfirm(ActionEvent event){
        String aktv = null;
        String goal1 = null;
        Double weight_t1 = null;

        try {
            aktv = getActivity(event);
            goal1 = getGoal(event);
            weight_t1 = getWeight(event);

            Stage stage = (Stage) confirm_button.getScene().getWindow();
            stage.close(); // zamkniecie okna po zapisie do bazy
        }catch(IllegalArgumentException | NullPointerException e){
            warning.setText("Wprowadzono niepoprawne dane.");
            e.printStackTrace();
        }

//        try{
//            // TUTAJ  MA BYC ODNIESIENIE SIe DO FUNKCJI KTÓRA
//            // PRZENIESIESIE STARE DANE DO ARCHIWUM (TRIGGER CHYBA JAKIS) I ZAPISZE
//            // NOWE DO BAZY
//
//        }catch (){
//            e.printStackTrace();
//        }


    }
}
