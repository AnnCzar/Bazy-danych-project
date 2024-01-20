package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "products", schema = "calories_base", catalog = "")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "kalc")
    private double kalc;
    @Basic
    @Column(name = "proteins")
    private double proteins;
    @Basic
    @Column(name = "carbs")
    private double carbs;
    @Basic
    @Column(name = "fat")
    private double fat;
    @Basic
    @Column(name = "daily_consumption")
    private Integer dailyConsumption;
    @ManyToOne
    @JoinColumn(name = "daily_consumption", referencedColumnName = "id")
    private DailyConsumptionEntity dailyConsumptionByDailyConsumption;

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
        ProductsEntity that = (ProductsEntity) o;
        return productId == that.productId && Double.compare(kalc, that.kalc) == 0 && Double.compare(proteins, that.proteins) == 0 && Double.compare(carbs, that.carbs) == 0 && Double.compare(fat, that.fat) == 0 && Objects.equals(productName, that.productName) && Objects.equals(dailyConsumption, that.dailyConsumption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, kalc, proteins, carbs, fat, dailyConsumption);
    }

    public DailyConsumptionEntity getDailyConsumptionByDailyConsumption() {
        return dailyConsumptionByDailyConsumption;
    }

    public void setDailyConsumptionByDailyConsumption(DailyConsumptionEntity dailyConsumptionByDailyConsumption) {
        this.dailyConsumptionByDailyConsumption = dailyConsumptionByDailyConsumption;
    }
}