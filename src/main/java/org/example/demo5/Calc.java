package org.example.demo5;

import javafx.event.ActionEvent;

public class Calc extends Controller {
    // nw jeszcze czy trzeba do kazdego osobny action event czy to nie starczy jeden
    protected ActionEvent event;
//    protected ActionEvent event_goal;
//    protected ActionEvent event_meals;
    protected ActionEvent gender;
    protected String activity = getActivity(event);
    protected String goal = getGoal(event);
    protected int meal_count = getMeals(event);
    protected String gend = getGender(event);
    protected double height = getHeight(event);
    protected double weight = getWeight(event);
    protected int age = getAge(event);
    public double cpm() {
        double index;
        double ppm = 0;

        if (activity.equals( "brak (osoba chora, leżąca w łóżku)")) {
            index = 1.2;
        } else if (activity.equals("mała (osoba wykonująca pracę siedzącą)")) {
            index = 1.4;
        } else if (activity.equals(("umiarkowana (osoba wykonująca pracę na stojąco)"))) {
            index = 1.6;
        } else if (activity.equals("duża (osoba prowadząca aktywny tryb życia, regularnie ćwicząca)")) {
            index = 1.75;
        } else if (activity.equals("bardzo duża (osoba prowadząca bardzo aktywny tryb życia, codziennie ćwicząca)")) {
            index = 2.0;
        } else {
            index = 2.4;
        }
        if (gend.equals("female")) {
            ppm = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
        } else if (gend.equals("male")) {
            ppm = 66.473 + (13.752 * weight) + (5.003 * height) - (6.775 * age);
        }
        double cpm = ppm * index;
        return cpm;
    }
}