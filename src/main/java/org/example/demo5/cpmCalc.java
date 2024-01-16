package org.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class cpmCalc extends Controller {
    protected ActionEvent event_act;
    protected ActionEvent event_goal;
    protected ActionEvent event_meals;
    protected String activity = getActivity(event_act);
    protected String goal = getGoal(event_goal);
    protected int meal_count = getMeals(event_meals);

    

}