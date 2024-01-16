package org.example.demo5;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import javafx.scene.control.Spinner;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

public class HelloController implements Initializable {

    @FXML
    private Label activity_l;

    @FXML
    private ChoiceBox<String> akt;

    @FXML
    private Label gender_l;

    @FXML
    private ChoiceBox<String> goal;

    @FXML
    private Label goal_l;

    @FXML
    private Label height_h;

    @FXML
    private TextField height_t;

    @FXML
    private CheckBox male;

    @FXML
    private Spinner<Integer> meals;

    @FXML
    private Label meals_l;

    @FXML
    private TextField name;

    @FXML
    private Label name_l;

    @FXML
    private Label weight_l;

    @FXML
    private TextField weight_t;

    @FXML
    private CheckBox woman;

    private String[] activity = {
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
    int currentValue;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        akt.getItems().addAll(activity);
        goal.getItems().addAll(goals);
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,6);
        valueFactory.setValue(1);
        meals.setValueFactory(valueFactory);
    }

    // Jeśli chcesz reagować na zdarzenia związane z wyborem w ChoiceBox, możesz to zrobić w osobnej metodzie, np.:
    @FXML
    private void getActivity(ActionEvent event) {
        String selectedActivity = akt.getValue();
        System.out.println("Selected Activity: " + selectedActivity);
    }
    @FXML
    private void getGoal(ActionEvent ev) {
        String selectedGoal = goal.getValue();

    }
    @FXML
    private void getMeals(ActionEvent ev) {
        currentValue = meals.getValue();

    }
}
