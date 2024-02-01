package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "daily_consumption", schema = "calories_base", catalog = "")
public class DailyConsumptionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "meals")
    private String meals;
    @Basic
    @Column(name = "kalc")
    private double kalc;
    @Basic
    @Column(name = "proteins")
    private double proteins;
    @Basic
    @Column(name = "fat")
    private double fat;
    @Basic
    @Column(name = "carbs")
    private double carbs;
    @Basic
    @Column(name = "user_name")
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
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

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyConsumptionEntity that = (DailyConsumptionEntity) o;
        return id == that.id && Double.compare(kalc, that.kalc) == 0 && Double.compare(proteins, that.proteins) == 0 && Double.compare(fat, that.fat) == 0 && Double.compare(carbs, that.carbs) == 0 && Objects.equals(date, that.date) && Objects.equals(meals, that.meals) && Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, meals, kalc, proteins, fat, carbs, userName);
    }
}
