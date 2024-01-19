package org.example.demo5;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//import java.lang.foreign.ValueLayout;
import java.io.IOException;
import java.net.URL;
import javafx.scene.control.Spinner;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller implements Initializable {
    @FXML
    public Label warn_user_name;
    @FXML
    public Label warn_weight;
    @FXML
    public Label warn_age;
    @FXML
    public Label warn_gender;
    @FXML
    public Label wrong_data;

    // dodać przycisk cos typu "przejdz dalej" jak klikniemy oblicz to sie pojawi i przejdzie do okna z MainApp
    // zrobic okno dodawania uzytkownika
    // zmienne  z okna
    @FXML
    private Label activity_l;

    @FXML
    private ChoiceBox<String> akt;

    @FXML
    private Button count;

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

    @FXML
    private Label warn;

    @FXML
    private Label kcal;

    @FXML
    private Label carb;

    @FXML
    private Label fats;

    @FXML
    private Label prot;

    @FXML
    private Button next_window;



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
    private Calc calculator;
    public Controller() {
        this.calculator = new Calc();
    }
    private double cpmResult;
    private MainAppController mainAppController;

    public void setMainAppController(MainAppController mainAppController) {
        this.mainAppController = mainAppController;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         *
         */
        if (akt != null) {
            akt.getItems().addAll(activity);
        }
        goal.getItems().addAll(goals);
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(3,6);
        valueFactory.setValue(3);
        meals.setValueFactory(valueFactory);
        count.setOnAction(event -> buttonAction());  // gdy sie kliknie przycisk
        name.setOnAction(this::getName); // ew. dodanie przycisku potwierdz imie
        next_window.setOnAction(event -> {
            try {
                handleCloseOpenButtonAction();
                mainAppController.set_number_meals(getMeals());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
//        if(!male.isSelected() ^ woman.isSelected()){
//            warn_gender.setText("Wybierz jedną płeć"); // do poprawy
//        }
    }



    @FXML
    public void handleCloseOpenButtonAction() throws IOException {  // przejscie do nowego okna
        try {
            Stage stage = (Stage) next_window.getScene().getWindow();
            stage.close();


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 700);
            stage.setTitle("Dzienne spożycie");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    // sciaganie danych z okna dodaj bloki try catch i wyswieltenie okna gdy nie wybrano jakiego parametru
    @FXML
    public String getActivity(ActionEvent event) {
        /**
         *
         */
        String selectedActivity = akt.getValue();
        return selectedActivity;
    }
    @FXML
    public String getGoal(ActionEvent ev) {
        /**
         *
         */
        String selectedGoal = goal.getValue();
        return selectedGoal;
    }

    @FXML
    public Integer getMeals() {
        /**
         *
         */
        currentValue = meals.getValue();
        return currentValue;
    }

    // trzeba bedzie dodac zabezpieczenie jakby 2 na raz byly zaznaczone
    @FXML
    public String getGender(ActionEvent event) {
        /**
         *
         */
        if(woman.isSelected()) {
            return "female";
        } else if (male.isSelected()) {
            return "male";
        }
        return "nothing is selected";
    }

    @FXML
    public double getHeight(ActionEvent event) {
        /**
         *
         */
        Double height = 0.0;
        try {
            height = Double.parseDouble(height_t.getText());
        }catch(NumberFormatException e){
            // alert window

        }
        return height;
    }
    @FXML
    public double getWeight(ActionEvent event) {
        /**
         *
         */
        double weight = Double.parseDouble(weight_t.getText());
        return weight;
    }
    @FXML
    public int getAge(ActionEvent event) {
        /**
         *
         */
        int age = Integer.parseInt(age_t.getText());
        return age;
    }
    @FXML
    public String getName(ActionEvent event) {
        /**
         *
         */
        try{
            // check if the name, which user choose is avilable
            String username = name.getText();
            if (username.equals("ania")){ // pamietac zeby poprawic na sprawdzanie po bazie
                warn_user_name.setText("Nazwa użytkownika zajęta");
                return null;
            }
            else{
                return name.getText();
            }

        }catch(NullPointerException e){
            e.printStackTrace();
            return null;
        }
//        String username = name.getText();
//        return username;
    }

    // tutaj metoda gdy sie wcisnie przycisk oblicz
    // dodac klase z dodaawnie do  bazy jak przejda obliczenia
    @FXML
    public void buttonAction() {
        /**
         *
         */
        String aktv = null;
        String goal1 = null;
        Integer meals1 = null;
        Double height_1 = null;
        Double weight_t1 = null;
        Integer age_t1 = null;

        try {
            aktv = akt.getValue();
            goal1 = goal.getValue();
            meals1 = meals.getValue();
            height_1 = Double.parseDouble(height_t.getText());
            weight_t1 = Double.parseDouble(weight_t.getText());
            age_t1 = Integer.parseInt(age_t.getText());
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        try {
            warn.setText("");  // if you click again button
            kcal.setText("");
            prot.setText("");
            carb.setText("");
            fats.setText("");
            wrong_data.setText("");
            if (height_1 <= 0 || weight_t1 <=0 || age_t1 <=0){
                wrong_data.setText("Wprowadzono niepoprawne dane.");
            }
            else {

                double cpmResult = calculator.cpm(
                        aktv,
                        goal1,
                        meals1,
                        male.isSelected() ? "male" : (woman.isSelected() ? "female" : "nothing is selected"),
                        height_1,
                        weight_t1,
                        age_t1
                );
                double bmi = calculator.calc_bmi(Double.parseDouble(weight_t.getText()), Double.parseDouble(height_t.getText()));
                String acc = calculator.acceptor(bmi, goal.getValue());



                if (acc == "") {
                    double kcal_prot = Math.round(0.25 * cpmResult * 100.0) / 100.0;
                    double kcal_fat = Math.round(0.3 * cpmResult * 100.0) / 100.0;
                    double kcal_carbs = Math.round(0.45 * cpmResult * 100) / 100.0;
                    kcal.setText("CPM: " + Math.round(cpmResult * 100.0) / 100.0);
                    prot.setText("kcal z białka:\n " + kcal_prot);
                    carb.setText("kcal z węglowodanów:\n " + kcal_carbs);
                    fats.setText("kcal z tłuszczy:\n " + kcal_fat);
                    next_window.setVisible(true);
                    // ZAPIS DO BAZY
                } else {
                    warn.setText(acc);
                }
            }
// pozniej poprzesuwam te labele zeby ladniej wygladaly
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
