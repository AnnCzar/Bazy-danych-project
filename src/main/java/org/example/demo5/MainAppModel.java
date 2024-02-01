package org.example.demo5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainAppModel {

    private Calc calculator;

    public void Controller() {

        this.calculator = new Calc();
    }

    public void add_daily_consumption(String name_of_product,Double weight_of_product, String user_name, Date date_breakfast){

        //SCIĄGNIECIE INFO O MAKRO I KCAL Z BAZY 'products' NA PODSTAWIE 'name_of_prduct'

//            Double kcal =
//            Double proteins =
//            Double carbs =
//            Double fat =
//            calculator.liczenie_kcal(kcal, proteins, carbs, fat, weight_of_product);

        // DODWANIE DO BAZY 'daily_consumption'
    }

    public List<Double> sum_daily_consumption(String user_name, Date date){

        // SCIĄGNIECIE Z BAZY 'daily_consumption' NA PODSTAWIE NAZWY UZYTKOWNIKA I DATY, ZWORCENIE KCAL, PRTOEIN, CARBS, FATS


        //    Double kcal =
//            Double proteins =
//            Double carbs =
//            Double fat =

        List<Double> result = new ArrayList<Double>();
//        result.add(kcal);
//        result.add(proteins);
//        result.add(carbs);
//        result.add(fat);

        return result;
    }

    public Double left_daily_consumption(String user_name, Date date){

        // SCIĄGNIECIE Z BAZY 'daily_consumption' NA PODSTAWIE NAZWY UZYTKOWNIKA I DATY, ZWORCENIE KCAL Z PRODUKOTW


        Double kcal_daily =0.0;

        // SCIAGNIECIE Z BAZY 'users' NA PODSTAWIE NAZWY UZYTKWONIKA JEGO ILSOCI KCAL DO SPOZYCIA
        Double kcal_goal = 0.0;
        Double result = kcal_goal - kcal_daily;
        return result;
    }


}
