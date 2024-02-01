package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "meals", schema = "calories_base", catalog = "")
public class MealsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "meal_id")
    private int mealId;
    @Basic
    @Column(name = "meal_name")
    private String mealName;
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
    @Column(name = "products")
    private String products;
    @Basic
    @Column(name = "daily_consumption")
    private Integer dailyConsumption;
    @ManyToOne
    @JoinColumn(name = "daily_consumption", referencedColumnName = "id")
    private DailyConsumptionEntity dailyConsumptionByDailyConsumption;

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
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

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public Integer getDailyConsumption() {
        return dailyConsumption;
    }

    public void setDailyConsumption(Integer dailyConsumption) {
        this.dailyConsumption = dailyConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealsEntity that = (MealsEntity) o;
        return mealId == that.mealId && Double.compare(kalc, that.kalc) == 0 && Double.compare(proteins, that.proteins) == 0 && Double.compare(fat, that.fat) == 0 && Double.compare(carbs, that.carbs) == 0 && Objects.equals(mealName, that.mealName) && Objects.equals(products, that.products) && Objects.equals(dailyConsumption, that.dailyConsumption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, mealName, kalc, proteins, fat, carbs, products, dailyConsumption);
    }

    public DailyConsumptionEntity getDailyConsumptionByDailyConsumption() {
        return dailyConsumptionByDailyConsumption;
    }

    public void setDailyConsumptionByDailyConsumption(DailyConsumptionEntity dailyConsumptionByDailyConsumption) {
        this.dailyConsumptionByDailyConsumption = dailyConsumptionByDailyConsumption;
    }
}
