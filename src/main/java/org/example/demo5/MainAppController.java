package org.example.demo5;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    private DatePicker date;

    @FXML
    private TextField din_search;

    @FXML
    private Label intake;

    @FXML
    private Label intake_l;

    @FXML
    private Label lunch;

    @FXML
    private TextField lunch_search;

    @FXML
    private TableView<?> prod_bd;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
