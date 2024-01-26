package org.example.demo5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {


    public Label snack_t;
    public ComboBox brSearchComboBox2;
    public ComboBox brSearchComboBox3;
    public ComboBox brSearchComboBox4;
    public ComboBox brSearchComboBox5;
    public ComboBox brSearchComboBox6;
    public Label snack_1;
    public Label snack_3;
    public Label snack_2;
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

    @FXML
    private TableColumn<?, ?> id_col;

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

    public Integer number_meals = 0;
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


    private final ObservableList<String> database = FXCollections.observableArrayList("Chleb", "Mleko", "Jajka", "Pomarańcze", "Marchewki", "Pasta do zębów", "Ser", "Ryż");

    @FXML
    private ComboBox<String> brSearchComboBox1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAutoComplete(br_search, database, brSearchComboBox1);
        initAutoComplete(s1_search, database, brSearchComboBox2);
        initAutoComplete(lunch_search, database, brSearchComboBox3);
        initAutoComplete(s2_search, database, brSearchComboBox4);
        initAutoComplete(din_search, database, brSearchComboBox5);
        initAutoComplete(s3_search, database, brSearchComboBox6);
        //dodac pozniej w view.xml onAction do przyciskow
//        add_b.setOnAction(button_add_b());
//        add_d.setOnAction();
//        add_l.setOnAction();
//        add_s3.setOnAction();
//        add_s2.setOnAction();
//        add_s1.setOnAction();

    }
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



    @FXML
    public LocalDate get_date(ActionEvent event){
        return date.getValue();
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


    public void set_number_meals(Integer meals) {
        // nie przesyła ilosci posiłków
        number_meals = meals;
        if(number_meals == 4){
            snack1.setVisible(true);
            s1_search.setVisible(true);
            snack1_t.setVisible(true);
        }else if(number_meals == 5){
            snack1.setVisible(true);
            s1_search.setVisible(true);
            snack1_t.setVisible(true);
            snack2.setVisible(true);
            s2_search.setVisible(true);
            snack_2.setVisible(true);
        }else if (number_meals == 6){
            snack1.setVisible(true);
            s1_search.setVisible(true);
            snack1_t.setVisible(true);
            snack2.setVisible(true);
            s2_search.setVisible(true);
            snack_2.setVisible(true);
            snack3.setVisible(true);
            s3_search.setVisible(true);
            snack_3.setVisible(true);

        }
    }

}
