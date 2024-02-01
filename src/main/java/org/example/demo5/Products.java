package org.example.demo5;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Products {

    private int productId;
    private String productName;
    private double kalc;
    private double proteins;
    private double carbs;
    private double fat;

    public Products(int productId, String productName, double kalc, double proteins, double carbs, double fat) {
        this.productId = productId;
        this.productName = productName;
        this.kalc = kalc;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fat = fat;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getKalc() {
        return kalc;
    }

    public void setKalc(double kalc) {
        this.kalc = kalc;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", kalc=" + kalc +
                ", proteins=" + proteins +
                ", carbs=" + carbs +
                ", fat=" + fat +
                '}';
    }

}
