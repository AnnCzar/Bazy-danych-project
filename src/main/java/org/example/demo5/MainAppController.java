package org.example.demo5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {

    @FXML
    public Label snack_t;
    @FXML
    public ComboBox<String> brSearchComboBox2;
    @FXML
    public ComboBox<String> brSearchComboBox3;
    @FXML
    public ComboBox<String> brSearchComboBox4;
    @FXML
    public ComboBox<String> brSearchComboBox5;
    @FXML
    public ComboBox<String> brSearchComboBox6;
    @FXML
    public Label snack_1;
    @FXML
    public Label snack_3;
    @FXML
    public Label snack_2;
    @FXML
    public Label snack1w;
    @FXML
    public Label snack2w;
    @FXML
    public Label snack3w;
    @FXML
    public TextField snack1_weight;
    @FXML
    public TextField br_weight;
    @FXML
    public TextField lunch_weight;
    @FXML
    public TextField snack2_weight;
    @FXML
    public TextField dinner_weight;
    @FXML
    public TextField snack3_weight;
    @FXML
    public Button goal_change;
    @FXML
    private Spinner<Integer> meals;
    @FXML
    private TextField br_search;
    @FXML
    private Label brekkie;
    @FXML
    private TableColumn<?, ?> carbs_col;
    @FXML
    private DatePicker date;
    @FXML
    private TextField din_search;
    @FXML
    private TableColumn<?, ?> fats_col;
//    @FXML
//    private TableColumn<?, ?> id_col;
    @FXML
    private Label intake;
    @FXML
    private Label intake_l;
    @FXML
    private TableColumn<?, ?> kcal_col;
    @FXML
    private Label lunch;
    @FXML
    private TextField lunch_search;
    @FXML
    private TableView<?> prod_bd;
    @FXML
    private TableColumn<?, ?> prod_col;
    @FXML
    private TableColumn<?, ?> prot_col;
    @FXML
    private TextField s1_search;

    @FXML
    private TextField s2_search;

    @FXML
    private TextField s3_search;

    @FXML
    private Label snack1;

    @FXML
    private Label snack2;

    @FXML
    private Label snack3;

    @FXML
    private Label dinner;

    @FXML
    private Label snack1_t;

    @FXML
    private Button add_b;

    @FXML
    private Button add_s1;

    @FXML
    private Button add_l;

    @FXML
    private Button add_s2;

    @FXML
    private Button add_d;

    @FXML
    private Button add_s3;

    @FXML
    private Label kcal_intake;
    @FXML
    private Label protein_intake;
    @FXML
    private Label carbs_intake;
    @FXML
    private Label fats_intake;
    @FXML
    private Label kcal_left;

    @FXML
    private String username;

    // PROBA PRZEKAZANIA NAZWY UZYTKOWNIKA
    private Stage thisStage;
    private logController logcontroller;
    public MainAppController(logController logcontroller){
        this.logcontroller = logcontroller;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            thisStage = new Stage();
            thisStage.setScene(new Scene(root));
            thisStage.setTitle("Dzienne spożycie");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String userName(){
        System.out.println("działa1");
        this.username = logcontroller.getUserName();
        return username;
    }
    // SPRAWDZENIE CZY DOBRZE DZIALA PRZEKAZANIE NAZWY - DO USUNIECIA
//    private String userName(){
//        username = logcontroller.getUserName();
//        return username;
//    }
    public void showStage() {
        thisStage.showAndWait();
    }

    private final ObservableList<String> database = FXCollections.observableArrayList("Chleb", "Mleko", "Jajka", "Pomarańcze", "Marchewki", "Pasta do zębów", "Ser", "Ryż");
        // funkcja siacgajaca nazwy produktów
    @FXML
    private ComboBox<String> brSearchComboBox1;
    private Calc calculator;

    public void Controller() {

        this.calculator = new Calc();
    }
// ODWOLANIE DO MODELU
    private MainAppModel model;
    public void Model(){
        this.model = new MainAppModel();
    }

    @FXML
    public void handleCloseOpenButtonAction1() throws IOException {  // przejscie do nowego okna

        Stage stage = (Stage) goal_change.getScene().getWindow();
        stage.close();
        openNewApp1(stage);
    }

    @FXML
    private void openNewApp1(Stage stage) {
        try {
            newgoalApp newgoal = new newgoalApp();
            newgoal.start(stage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        // ZMIENNE DO ZAPISU
    Date d;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        userName(); // PRZYPISANIE DO ZMIENNEJ  'username' wprowadzonego username w oknie logowania
        date.setOnAction(this::get_date);

        //FUNKCJA ŁADUJĄCA DANE DO TABELI Z DANEGO DNIA NA PODSATWIE NAZWY UZYTKOWNIKA (WYWOŁANIE NAZWY UZYTKOWANIKA
        // 'username()' oraz daty 'get_date')

        initAutoComplete(br_search, database, brSearchComboBox1);
        initAutoComplete(s1_search, database, brSearchComboBox2);
        initAutoComplete(lunch_search, database, brSearchComboBox3);
        initAutoComplete(s2_search, database, brSearchComboBox4);
        initAutoComplete(din_search, database, brSearchComboBox5);
        initAutoComplete(s3_search, database, brSearchComboBox6);
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(3, 6);
        valueFactory.setValue(3);
        meals.setValueFactory(valueFactory);
        meals.valueProperty().addListener((observable, oldValue, newValue) -> {
            set_number_meals();
        });
        goal_change.setOnAction(event -> {
            try {
                handleCloseOpenButtonAction1();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });




        //dodac pozniej w view.xml onAction do przyciskow
        add_b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button_add_s1(event);
//                button_another_function(event);
            }
        });
//        add_s1.setOnAction(event -> );
        add_d.setOnAction(this::button_add_d);
        add_l.setOnAction(this::button_add_l);
        add_s3.setOnAction(this::button_add_s3);
        add_s2.setOnAction(this::button_add_s2);
        add_s1.setOnAction(this::button_add_s1);

    }
    @FXML
    private void table_daily_consumption(){
        // SCIAGNIECIE NA PODSTAWIE ANZWY UZYTKOWNIKA ORAZ DATY DODANYCH PRODUKTÓW DO 'daily_consumption'

    }
    @FXML
    private void initAutoComplete(TextField textField, ObservableList<String> data, ComboBox<String> brSearchComboBox ) {
        // Tworzenie listy rozwijanej (ComboBox) do wyświetlania sugerowanych opcji
        brSearchComboBox.setVisibleRowCount(5); // Ustawienie liczby widocznych sugerowanych opcji

        // Ustawienie danych bazy danych dla listy rozwijanej
        brSearchComboBox.setItems(data);

        // Nasłuchiwanie zmian w polu tekstowym
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            String enteredText = textField.getText().toLowerCase();

            // Filtruj dane z bazy danych na podstawie wprowadzonego tekstu
            ObservableList<String> filteredData = FXCollections.observableArrayList();
            for (String item : data) {
                if (item.toLowerCase().startsWith(enteredText)) {
                    filteredData.add(item);
                }
            }
            // Ustawienie przefiltrowanych danych jako elementów listy rozwijanej
            brSearchComboBox.setItems(filteredData);

            // Wyświetlanie listy rozwijanej
            brSearchComboBox.show();
        });

        // Nasłuchiwanie wybrania sugerowanej opcji z listy rozwijanej
        brSearchComboBox.setOnAction(event -> {
            // Ustawienie wybranej opcji jako tekst w polu tekstowym
            textField.setText(brSearchComboBox.getValue());
            // Ukrycie listy rozwijanej
            brSearchComboBox.hide();
        });

        // Ukrycie listy rozwijanej po kliknięciu na inne miejsce
        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                brSearchComboBox.hide();
            }
        });
    }


    //WYCIAGNEICIE DATY Z KALENDARZA
    @FXML
    public Date get_date(ActionEvent event){
        LocalDate a = date.getValue();
        this.d =  Date.from(a.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        return Date.from(a.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        return d;
    }

    @FXML
    public String get_b(){
        return br_search.getText();
    }

    @FXML
    public String get_s1(){
        return s1_search.getText();
    }

    @FXML
    public String get_l(){
        return lunch_search.getText();
    }

    @FXML
    public String get_s2(){
        return s2_search.getText();
    }

    @FXML
    public String get_d(){
        return din_search.getText();
    }
    @FXML
    public String get_s3(){
        return s3_search.getText();
    }



    @FXML
    public Double get_weight_b(){return Double.parseDouble(br_weight.getText());}
    @FXML
    public Double get_weightb_s1(){return Double.parseDouble(snack1_weight.getText());}
    @FXML
    public Double get_weight_l(){return Double.parseDouble(lunch_weight.getText());}
    @FXML
    public Double get_weight_s2(){return Double.parseDouble(snack2_weight.getText());}
    @FXML
    public Double get_weight_d(){return Double.parseDouble(dinner_weight.getText());}
    @FXML
    public Double get_weight_s3(){return Double.parseDouble(snack3_weight.getText());}
    @FXML
    public void button_add_b(ActionEvent event){
        try{
            String name_of_product = get_b();
            Double weight_of_product = get_weight_b();
            String user_name = userName();
            Date date_breakfast = get_date(event);

            model.add_daily_consumption(name_of_product, weight_of_product, user_name, date_breakfast);

        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    @FXML
    public void button_add_s1(ActionEvent event){
        try{
            String name_of_product = get_s1();
            Double weight_of_product = get_weightb_s1();
            String user_name = userName();
            Date date_snack1 = get_date(event);

            model.add_daily_consumption(name_of_product, weight_of_product, user_name, date_snack1);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }

    }@FXML
    public void button_add_l(ActionEvent event){

        try{
            String name_of_product = get_l();
            Double weight_of_product = get_weight_l();
            String user_name = userName();
            Date date_lunch= get_date(event);

            model.add_daily_consumption(name_of_product, weight_of_product, user_name, date_lunch);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    @FXML
    public void button_add_s2(ActionEvent event){

        try{
            String name_of_product = get_s2();
            Double weight_of_product = get_weight_s2();
            String user_name = userName();
            Date date_snack2 = get_date(event);

            model.add_daily_consumption(name_of_product, weight_of_product, user_name, date_snack2);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    @FXML
    public void button_add_d(ActionEvent event){

        try{
            String name_of_product = get_d();
            Double weight_of_product = get_weight_d();
            String user_name = userName();
            Date date_dinner = get_date(event);

            model.add_daily_consumption(name_of_product, weight_of_product, user_name, date_dinner);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    @FXML
    public void button_add_s3(ActionEvent event){
        try{
            String name_of_product = get_s3();
            Double weight_of_product = get_weight_s3();
            String user_name = userName();
            Date date_snack3= get_date(event);

            model.add_daily_consumption(name_of_product, weight_of_product, user_name, date_snack3);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    public Integer getMeals(){
        return meals.getValue();
    }

    public void set_number_meals() {
        // Tablice komponentów
        Label[] snacks = {snack1, snack2, snack3};
        TextField[] searches = {s1_search, s2_search, s3_search};
        Label[] snackLabels = {snack_1, snack_2, snack_3};
        Label[] snackWeights = {snack1w, snack2w, snack3w};
        TextField[] snackWeightFields = {snack1_weight, snack2_weight, snack3_weight};
        Button[] addButtons = {add_s1, add_s2, add_s3};

        // Ukryj wszystkie komponenty
        for (Label snack : snacks) snack.setVisible(false);
        for (TextField search : searches) search.setVisible(false);
        for (Label label : snackLabels) label.setVisible(false);
        for (Label weight : snackWeights) weight.setVisible(false);
        for (TextField weightField : snackWeightFields) weightField.setVisible(false);
        for (Button addButton : addButtons) addButton.setVisible(false);

        // Wyświetl komponenty zgodnie z ilością posiłków
        int meals = getMeals();
        switch (meals) {
            case 4:
                snacks[0].setVisible(true);
                searches[0].setVisible(true);
                snackLabels[0].setVisible(true);
                snackWeights[0].setVisible(true);
                snackWeightFields[0].setVisible(true);
                addButtons[0].setVisible(true);
                break;
            case 5:
                snacks[0].setVisible(true);
                searches[0].setVisible(true);
                snackLabels[0].setVisible(true);
                snackWeights[0].setVisible(true);
                snackWeightFields[0].setVisible(true);
                addButtons[0].setVisible(true);

                snacks[1].setVisible(true);
                searches[1].setVisible(true);
                snackLabels[1].setVisible(true);
                snackWeights[1].setVisible(true);
                snackWeightFields[1].setVisible(true);
                addButtons[1].setVisible(true);
                break;
            case 6:
                for (int i = 0; i < 3; i++) {
                    snacks[i].setVisible(true);
                    searches[i].setVisible(true);
                    snackLabels[i].setVisible(true);
                    snackWeights[i].setVisible(true);
                    snackWeightFields[i].setVisible(true);
                    addButtons[i].setVisible(true);
                }
                break;
        }
    }
    private void daily_intake_left(ActionEvent event){
        Date data = get_date(event);
        String username = userName();

        // FUNKCJA Z MODELU

        List<Double> result = new ArrayList<Double>();

        result = model.sum_daily_consumption(username, data);

        kcal_intake.setText(String.valueOf(result.get(0)));
        protein_intake.setText(String.valueOf(result.get(1)));
        carbs_intake.setText(String.valueOf(result.get(2)));
        fats_intake.setText(String.valueOf(result.get(3)));

        Double result1 = model.left_daily_consumption(username, data);
        kcal_left.setText(String.valueOf(result1));

        //
    }






}
