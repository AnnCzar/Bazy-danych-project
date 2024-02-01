
package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "products_to_meals", schema = "calories_base", catalog = "")
public class ProductsToMealsEntity {
    @Basic
    @Id
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "meal_id")
    private int mealId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false, insertable=false, updatable=false)
    private ProductsEntity productsByProductId;
    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "meal_id", nullable = false, insertable=false, updatable=false)
    private MealsEntity mealsByMealId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsToMealsEntity that = (ProductsToMealsEntity) o;
        return productId == that.productId && mealId == that.mealId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, mealId);
    }

    public ProductsEntity getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(ProductsEntity productsByProductId) {
        this.productsByProductId = productsByProductId;
    }

    public MealsEntity getMealsByMealId() {
        return mealsByMealId;
    }

    public void setMealsByMealId(MealsEntity mealsByMealId) {
        this.mealsByMealId = mealsByMealId;
    }
}

