
package org.example.demo5;
import entity.UserRepository;
import jakarta.persistence.Persistence;
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

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import jakarta.persistence.EntityManager;

// przesyłanie liczby posiłków do kolejnego okna

public class Controller implements Initializable {
    private EntityManager entityManager;



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

    @FXML
    private ChoiceBox<String> akt;

    @FXML
    private Button count;

    @FXML
    private ChoiceBox<String> goal;

    @FXML
    private TextField height_t;


    @FXML
    private ChoiceBox<String> sex_s;

    @FXML
    private TextField name;

    @FXML
    private TextField weight_t;

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
    private String[] sex_choice = {"kobieta", "mężczyzna"};


    private Calc calculator;


     private MainAppController mainAppController;

    public Controller() {

        this.calculator = new Calc();
    }
    private double cpmResult;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         *
         */
        if (akt != null) {
            akt.getItems().addAll(activity);
        }
        sex_s.getItems().addAll(sex_choice);

        goal.getItems().addAll(goals);
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(3,6);
        valueFactory.setValue(3);
        count.setOnAction(this::buttonAction);
        name.setOnAction(this::getName);
        next_window.setOnAction(event -> {
            try {
                handleCloseOpenButtonAction();
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

            Stage stage = (Stage) next_window.getScene().getWindow();
            stage.close();
            openMainApp(stage);
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


    // trzeba bedzie dodac zabezpieczenie jakby 2 na raz byly zaznaczone
    @FXML
    public String getGender(ActionEvent event) {
        String selectedSex = sex_s.getValue();
        return selectedSex;
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
    public int getAge(ActionEvent event) {  // wywalic do Calc
        /**
         *
         */
        String dateInput = age_t.getText();
        LocalDate dateOfBirth =  LocalDate.now();
        String date_reg1 = "^(\\d{4})-(\\d\\d*)-(\\d\\d*)$";
        Pattern pattern1 = Pattern.compile(date_reg1);
        Matcher matcher1 = pattern1.matcher(age_t.getText());

        String date_reg2 = "^(\\d{4}) (\\d\\d*) (\\d\\d*)$";
        Pattern pattern2 = Pattern.compile(date_reg2);
        Matcher matcher2 = pattern2.matcher(age_t.getText());
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            if (matcher1.matches()) {
                Integer year = Integer.parseInt(matcher1.group(1));
                Integer month = Integer.parseInt(matcher1.group(2));
                Integer day = Integer.parseInt(matcher1.group(3));
                String tem_date = calculator.Date_check(day, month, year);
                dateOfBirth = LocalDate.parse(tem_date, df);

            } else if (matcher2.matches()) {
                Integer year = Integer.parseInt(matcher2.group(1));
                Integer month = Integer.parseInt(matcher2.group(2));
                Integer day = Integer.parseInt(matcher2.group(3));
                String tem_date = calculator.Date_check(day, month, year);
                dateOfBirth = LocalDate.parse(tem_date, df);

            }else {
                return 0;
            }
        }catch(NumberFormatException e){        // sprawdzic czy dobry wyjątek wylapuje
            e.printStackTrace();
        }

        Period intervalPeriod = Period.between(dateOfBirth, currentDate);
        Integer age = intervalPeriod.getYears();

        System.out.println(age);
        return  age;
    }

    @FXML
    public String getName(ActionEvent event) {
        /**
         *
         */
        try{
            // check if the name, which user choose is avilable
            warn_user_name.setText("");
            String username = name.getText();
            if (username.equals("ania")){ // pamietac zeby poprawic na sprawdzanie po bazie
                //  funkcja sciaga nazwy uzytkonikow
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
    }

    @FXML
    public void buttonAction(ActionEvent event) {
        /**
         *
         */
        System.out.println("Przycisk został naciśnięty.");
        System.out.println(getAge(event));
        String aktv = null;
        String goal1 = null;
        Integer meals1 = null;
        Double height_1 = null;
        Double weight_t1 = null;
        Integer age_t1 = null;
        String sex_t = null;

        try {

            aktv = akt.getValue();
            goal1 = goal.getValue();
            height_1 = Double.parseDouble(height_t.getText());
            weight_t1 = Double.parseDouble(weight_t.getText());
            age_t1 = Integer.parseInt(String.valueOf(getAge(event)));
            sex_t = sex_s.getValue();
        }catch(NullPointerException e){
            wrong_data.setText("Wprowadzono niepoprawne dane.");
            e.printStackTrace();
        }


        try {
            warn.setText("");  // if you click again button
            kcal.setText("");
            prot.setText("");
            carb.setText("");
            fats.setText("");
            wrong_data.setText("");

            if (height_1 <= 0 || weight_t1 <=0 || age_t1 <=0  || age_t1 >= 150){
                wrong_data.setText("Wprowadzono niepoprawne dane.");
            }
            else if(getName(event) == null){
                getName(event);
            }
            else {

                double cpmResult = calculator.cpm(
                        aktv,
                        goal1,
                        meals1,
                        sex_t,
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
                    User user = new User(getName(event), getGender(event), weight_t1, height_1, age_t1, aktv, goal1);

                    UserService userService = new UserService(new UserRepository(entityManager));

                    userService.addUser(user);

                } else {
                    warn.setText(acc);
                }
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}

