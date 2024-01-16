package org.example.demo5;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import javafx.scene.control.Spinner;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.SpinnerValueFactory;

public class Controller implements Initializable {

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

    @FXML
    private Label age_l;

    @FXML
    private TextField age_t;


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
    public String getActivity(ActionEvent event) {
        String selectedActivity = akt.getValue();
        return selectedActivity;
    }
    @FXML
    public String getGoal(ActionEvent ev) {
        String selectedGoal = goal.getValue();
        return selectedGoal;
    }

    @FXML
    public int getMeals(ActionEvent ev) {
        currentValue = meals.getValue();
        return currentValue;
    }
    @FXML
    public String getGender(ActionEvent event) {
        if(woman.isSelected()) {
            return "female";
        } else if (male.isSelected()) {
            return "male";
        }
        return "nothing is selected";
    }
    @FXML
    public double getHeight(ActionEvent event) {
        double height = Double.parseDouble(height_t.getText());
        return height;
    }
    @FXML
    public double getWeight(ActionEvent event) {
        double weight = Double.parseDouble(weight_t.getText());
        return weight;
    }
    @FXML
    public int getAge(ActionEvent event) {
        int age = Integer.parseInt(age_t.getText());
        return age;
    }
    @FXML
    public String getName(ActionEvent event) {
        String username = name.getText();
        return username;
    }
    @FXML
    public static void buttonAction(ActionEvent event) {
        
    }
}
