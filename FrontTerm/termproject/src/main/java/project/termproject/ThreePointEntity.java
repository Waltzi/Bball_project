package project.termproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private int practiceNumber;
    private String date;

    public void setDate(String date) {
        this.date = date;
    }
    
}