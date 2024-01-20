package entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "calories_base", catalog = "")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "sex")
    private Object sex;
    @Basic
    @Column(name = "weight")
    private double weight;
    @Basic
    @Column(name = "height")
    private double height;
    @Basic
    @Column(name = "age")
    private Integer age;
    @Basic
    @Column(name = "avg_activity")
    private Object avgActivity;
    @Basic
    @Column(name = "goal")
    private Object goal;
    @OneToMany(mappedBy = "usersByUserName")
    private Collection<DailyConsumptionEntity> dailyConsumptionsByUserName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Object getAvgActivity() {
        return avgActivity;
    }

    public void setAvgActivity(Object avgActivity) {
        this.avgActivity = avgActivity;
    }

    public Object getGoal() {
        return goal;
    }

    public void setGoal(Object goal) {
        this.goal = goal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Double.compare(weight, that.weight) == 0 && Double.compare(height, that.height) == 0 && Objects.equals(userName, that.userName) && Objects.equals(sex, that.sex) && Objects.equals(age, that.age) && Objects.equals(avgActivity, that.avgActivity) && Objects.equals(goal, that.goal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, sex, weight, height, age, avgActivity, goal);
    }

    public Collection<DailyConsumptionEntity> getDailyConsumptionsByUserName() {
        return dailyConsumptionsByUserName;
    }

    public void setDailyConsumptionsByUserName(Collection<DailyConsumptionEntity> dailyConsumptionsByUserName) {
        this.dailyConsumptionsByUserName = dailyConsumptionsByUserName;
    }
}
