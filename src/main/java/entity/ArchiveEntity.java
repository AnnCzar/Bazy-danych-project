package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "archive", schema = "calories_base", catalog = "")
public class ArchiveEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "archive_id")
    private int archiveId;
    @Basic
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
    @Column(name = "avg_kacl")
    private Double avgKacl;
    @Basic
    @Column(name = "avg_activity")
    private Object avgActivity;
    @Basic
    @Column(name = "goal")
    private Object goal;
    @Basic
    @Column(name = "end_date")
    private Date endDate;

    public int getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(int archiveId) {
        this.archiveId = archiveId;
    }

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

    public Double getAvgKacl() {
        return avgKacl;
    }

    public void setAvgKacl(Double avgKacl) {
        this.avgKacl = avgKacl;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArchiveEntity that = (ArchiveEntity) o;
        return archiveId == that.archiveId && Double.compare(weight, that.weight) == 0 && Double.compare(height, that.height) == 0 && Objects.equals(userName, that.userName) && Objects.equals(sex, that.sex) && Objects.equals(age, that.age) && Objects.equals(avgKacl, that.avgKacl) && Objects.equals(avgActivity, that.avgActivity) && Objects.equals(goal, that.goal) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archiveId, userName, sex, weight, height, age, avgKacl, avgActivity, goal, endDate);
    }
}
