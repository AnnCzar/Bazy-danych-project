package org.example.demo5;

import javafx.event.ActionEvent;

public class Calc {
    // nw jeszcze czy trzeba do kazdego osobny action event czy to nie starczy jeden
    public double cpm(String activity, String goal, int mealCount, String gender, double height, double weight, int age) {
        double index;
        double ppm = 0;
        double diff = 0;

        if (activity.equals("brak (osoba chora, leżąca w łóżku)")) {
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

        if (gender.equals("female")) {
            ppm = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
        } else if (gender.equals("male")) {
            ppm = 66.473 + (13.752 * weight) + (5.003 * height) - (6.775 * age);
        }
        if (goal.equals("schudnąć")) {
            diff = -0.15 * ppm;
        } else if(goal.equals("utrzymać wagę")) {
            diff = 0;
        } else if (goal.equals("przytyć")) {
            diff = 0.15 * ppm;
        }
// te wartosci bedzie mozna pozmieniac
        return ppm * index + diff;
    }
    public double calc_bmi (double weight, double height) {
        double bmi = weight / Math.pow(height/100,2);
        return bmi;
    }
    public String acceptor(double bmi, String goal) {
        if (bmi < 18.49 && (goal.equals("schudnąć") || goal.equals("utrzymać wagę"))) {
            return "WYBRANO CEL ZAGRAŻAJĄCY ZDROWIU";
        } else if (bmi >= 18.50 && bmi <= 24.99) {
            return "";
        } else if (bmi > 25 && (goal.equals("przytyć") || goal.equals("utrzymać wagę"))) {
            return "WYBRANO CEL ZAGRAŻAJĄCY ZDROWIU";
        }
        return "";
    }
    // dodac zeby nie pozwalalo przejsc dalej jak zagrazajacy zyciu


//    public double carbs_kcal(double cpm) {
//        return 0.45 * cpm;
//    }
//    public double protein_kcal(double cpm) {
//        return 0.25 * cpm;
//    }
//    public double fat_kcal(double cpm) {
//        return 0.3 * cpm;
//    }
}