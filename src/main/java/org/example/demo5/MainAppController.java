package org.example.demo5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import java.util.Date;
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
    private void userName(){
        this.username = logcontroller.getUserName();
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

//        set_number_meals();
        meals.valueProperty().addListener((observable, oldValue, newValue) -> {
            set_number_meals();
        });
        meals.setValueFactory(valueFactory);


        //dodac pozniej w view.xml onAction do przyciskow
//        add_b.setOnAction(button_add_b());
//        add_d.setOnAction();
//        add_l.setOnAction();
//        add_s3.setOnAction();
//        add_s2.setOnAction();
//        add_s1.setOnAction();

    }
    @FXML
    private void table_daily_consumption(){

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
    public void get_date(ActionEvent event){
        LocalDate a = date.getValue();
        this.d =  Date.from(a.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        return Date.from(a.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

    }

    @FXML
    public String get_b(){
        return brekkie.getText();
    }

    @FXML
    public String get_s1(){
        return snack1.getText();
    }

    @FXML
    public String get_l(){
        return lunch.getText();
    }

    @FXML
    public String get_s2(){
        return snack2.getText();
    }

    @FXML
    public String get_d(){
        return dinner.getText();
    }

    public void button_add_b(ActionEvent event){
        // odwołanie do funkcji z modelu, sprawdzenie czy jest taki produkt w bazie i dodanie go do bazy danych
    }

    public void button_add_s1(ActionEvent event){

        // odwołanie do funkcji z modelu, sprawdzenie czy jest taki produkt w bazie i dodanie go do bazy danych
        // aktualizacja satystyki na dole okna
    }
    public void button_add_l(ActionEvent event){

        // odwołanie do funkcji z modelu, sprawdzenie czy jest taki produkt w bazie i dodanie go do bazy danych
        // aktualizacja satystyki na dole okna
    }
    public void button_add_s2(ActionEvent event){

        // odwołanie do funkcji z modelu, sprawdzenie czy jest taki produkt w bazie i dodanie go do bazy danych
        // aktualizacja satystyki na dole okna
    }
    public void button_add_d(ActionEvent event){

        // odwołanie do funkcji z modelu, sprawdzenie czy jest taki produkt w bazie i dodanie go do bazy danych
        // aktualizacja satystyki na dole okna
    }

    public void button_add_s3(ActionEvent event){

        // odwołanie do funkcji z modelu, sprawdzenie czy jest taki produkt w bazie i dodanie go do bazy danych
        // aktualizacja satystyki na dole okna
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


}
