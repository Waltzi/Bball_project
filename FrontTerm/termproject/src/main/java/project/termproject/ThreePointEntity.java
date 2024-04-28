package project.termproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ThreePointers")
public class ThreePointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int jerseyNumber;
    private int threePointersMade;
    private int threePointersAttempted;
    private double threePointPercentage;
    private int practiceNum;
    private String date;

    public void setDate(String date) {
        this.date = date;
    }

    public int getThreePointersMade() {
        return threePointersMade;
    }

    public int getThreePointersAttempted() {
        return threePointersAttempted;
    }

    public void setThreePointPercentage(double threePointPercentage) {
        this.threePointPercentage = threePointPercentage;
    }

    public String getDate() {
        return this.date;
    }

    public int getPracticeNum() {
        return this.practiceNum;
    }

    public void setPracticeNum(int practiceNum) {
        this.practiceNum = practiceNum;
    }

    public int getJerseyNumber() {
        return this.jerseyNumber;
    }
    
}