package project.termproject;

import lombok.Data;

@Data
public class ThreePointModel {
    private Long id;
    private int jerseyNumber;
    private int threePointersMade;
    private int threePointersAttempted;
    private double threePointPercentage;
    private int practiceNum;
    private String date;
    
}
