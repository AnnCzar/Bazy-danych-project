package org.example.demo5;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {

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
    private Label snack1_t;
    protected MainController mainController;
    protected Integer number_meals = mainController.getMeals();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    if(number_meals == 4){
        snack1.setVisible(true);
        s1_search.setVisible(true);
        snack1_t.setVisible(true);
    }

    }

    public void set_number_meals(Integer meals) {
    }
//    public void set_number_meals(Integer meals){
//        if (meals != null){
//            number_meals = meals;
//        }else{
//            throw new IllegalArgumentException("Null");
//        }
//
//    }
}
