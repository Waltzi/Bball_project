package project.termproject;

import lombok.Data;

@Data
public class FreeThrowModel {
    private Long id;
    private int jerseyNumber;
    private int freeThrowsMade;
    private int freeThrowsAttempted;
    private double freeThrowPercentage;
    private int practiceNumber;
    private String date;
    
}
