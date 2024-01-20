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
    @Column(name = "avg_kalc")
    private Double avgKalc;
    @Basic
    @Column(name = "weight")
    private Double weight;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "avg_activity")
    private Object avgActivity;
    @Basic
    @Column(name = "goal")
    private Object goal;

    public int getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(int archiveId) {
        this.archiveId = archiveId;
    }

    public Double getAvgKalc() {
        return avgKalc;
    }

    public void setAvgKalc(Double avgKalc) {
        this.avgKalc = avgKalc;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        ArchiveEntity that = (ArchiveEntity) o;
        return archiveId == that.archiveId && Objects.equals(avgKalc, that.avgKalc) && Objects.equals(weight, that.weight) && Objects.equals(endDate, that.endDate) && Objects.equals(avgActivity, that.avgActivity) && Objects.equals(goal, that.goal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archiveId, avgKalc, weight, endDate, avgActivity, goal);
    }
}
