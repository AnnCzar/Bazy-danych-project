package org.example.demo5;

import javafx.event.ActionEvent;

public class Calc extends Controller {
    protected ActionEvent event_act;
    protected ActionEvent event_goal;
    protected ActionEvent event_meals;
    protected String activity = getActivity(event_act);
    protected String goal = getGoal(event_goal);
    protected int meal_count = getMeals(event_meals);

    public double cpm() {
        if (activity == "brak (osoba chora, leżąca w łóżku)") {

        }

    }

//    proba

}
"brak (osoba chora, leżąca w łóżku)",
        "mała (osoba wykonująca pracę siedzącą)",
        "umiarkowana (osoba wykonująca pracę na stojąco)",
        "duża (osoba prowadząca aktywny tryb życia, regularnie ćwicząca)",
        "bardzo duża (osoba prowadząca bardzo aktywny tryb życia, codziennie ćwicząca)",
        "osoba zawodowo uprawiająca sport"