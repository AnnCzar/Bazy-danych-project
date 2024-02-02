package org.example.demo5;

import entity.DailyConsumptionEntity;

import java.util.Collection;

public class User {
    private String userName;

    private Object sex ;

    private double weight;

    private double height;

    private Integer age;

    private Object avgActivity;
    private Object goal;

    private Collection<DailyConsumptionEntity> dailyConsumptionsByUserName;

    public User(String userName, Object sex, double weight, double height, Integer age, Object avgActivity, Object goal) {
        this.userName = userName;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.avgActivity = avgActivity;
        this.goal = goal;
        this.dailyConsumptionsByUserName = dailyConsumptionsByUserName;
    }

    public Object getSex() {
        return sex;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public Integer getAge() {
        return age;
    }

    public Object getAvgActivity() {
        return avgActivity;
    }

    public Object getGoal() {
        return goal;
    }

    public Collection<DailyConsumptionEntity> getDailyConsumptionsByUserName() {
        return dailyConsumptionsByUserName;
    }

    public String getUserName() {
        return userName;
    }

}

