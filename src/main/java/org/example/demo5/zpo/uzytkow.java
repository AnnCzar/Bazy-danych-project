package org.example.demo5.zpo;

import org.example.demo5.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents a user implementing the Uzytkownik interface.
 * This class provides methods to access and manipulate user data,
 * as well as saving user data to a CSV file.
 */
public class uzytkow implements Uzytkownik {
    // Fields to store user information
    private String userName;
    private Object sex;
    private double weight;
    private double height;
    private Integer age;
    private Object avgActivity;
    private Object goal;

    /**
     * Constructor to initialize a user with the provided information.
     *
     * @param userName     The username of the user.
     * @param sex          The gender of the user.
     * @param weight       The weight of the user.
     * @param height       The height of the user.
     * @param age          The age of the user.
     * @param avgActivity  The average activity level of the user.
     * @param goal         The goal of the user.
     */
    public uzytkow(String userName, Object sex, double weight, double height, Integer age, Object avgActivity, Object goal) {
        this.userName = userName;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.avgActivity = avgActivity;
        this.goal = goal;
    }

    /**
     * Get the gender of the user.
     *
     * @return The gender of the user.
     */
    public Object getSex() {
        return sex;
    }

    /**
     * Get the weight of the user.
     *
     * @return The weight of the user.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Get the height of the user.
     *
     * @return The height of the user.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Get the age of the user.
     *
     * @return The age of the user.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Get the average activity level of the user.
     *
     * @return The average activity level of the user.
     */
    public Object getAvgActivity() {
        return avgActivity;
    }

    /**
     * Get the goal of the user.
     *
     * @return The goal of the user.
     */
    public Object getGoal() {
        return goal;
    }

    /**
     * Get the username of the user.
     *
     * @return The username of the user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Add a user to the CSV file.
     *
     * @param uzytkow The User object to be added.
     */
    @Override
    public void addUser(User uzytkow) {
        // Define the path where you want to save the CSV file
        String csvFilePath = "C:\\Users\\Ania\\Repositories\\ZPO-project\\uzytkow.csv";

        // Write the user data to the CSV file using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {
            // Append user data to the CSV file
            writer.write(String.format("%s,%s,%.2f,%.2f,%d,%s,%s%n",
                    uzytkow.getUserName(), uzytkow.getSex(), uzytkow.getWeight(),
                    uzytkow.getHeight(), uzytkow.getAge(), uzytkow.getAvgActivity(), uzytkow.getGoal()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("User data saved to CSV file.");
    }
}