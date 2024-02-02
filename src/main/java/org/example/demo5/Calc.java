package org.example.demo5;

import javafx.event.ActionEvent;

import java.time.LocalDate;

public class Calc {
    // nw jeszcze czy trzeba do kazdego osobny action event czy to nie starczy jeden
    public double cpm(String activity, String goal, Integer mealCount, String gender, Double height,
                      double weight, Integer age) {
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

        if (gender.equals("kobieta")) {
            ppm = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
        } else if (gender.equals("mężczyzna")) {
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


    String Date_check(Integer day, Integer month, Integer year){
        int [] days_31 = {1, 3, 5, 7, 8,10, 12};              // Tablica do sprawdzania czy dany miesiąc ma 31 dni.
        String data = "";
        LocalDate date1 = null;

        if (day > 31){                // Rzucanie wyjątów dla źle wprowadzonych danych
            throw new IllegalArgumentException("Entered day is out of the range");
        }
        else if (month > 12){
            throw new IllegalArgumentException("Entered day is out of the range");
        }
        else if (day == 31 && (days_31.equals(month)== true)){        // formatowaanie dla daty, która ma 31 dni
            data += day;
            if (month < 10){
                data += "-0" + month + "-" + year;
            }
            else{
                data += "-" + month + "-" +  year;
            }
        }
        else if (day == 31 && (days_31.equals(month)== false)){           // Wyrzucenie wyjatku dla wprowadzonej daty np 31-04-2023
            throw new IllegalArgumentException("Date does not exist");
        }
        else if (month == 2){         // Foramtowanie dla daty z lutym
            if (day < 10 ){
                data += "0" + day + "-0" + month + "-" + year;
            }
            else if ( day > 29){
                throw new IllegalArgumentException(" Date does not exist");
            }
            else{
                data += day  + "-0" + month + "-" + year;
            }
        }
        else {
            if (day < 10 && month < 10){
                data += "0" + day + "-0" + month + "-" + year;
            }
            else if ( day < 10 && month >= 10){
                data += "0" + day + "-" + month + "-" + year;
            }
            else if (day > 9 && month > 9){
                data += day + "-" + month + "-" + year;
            }
            else {
                data += day + "-0" + month + "-" + year;
            }
        }
        return data;
    }

}