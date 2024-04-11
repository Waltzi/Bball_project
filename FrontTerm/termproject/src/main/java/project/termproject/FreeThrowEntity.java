package project.termproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "FreeThrow")
public class FreeThrowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int jerseyNumber;
    private int freeThrowsMade;
    private int freeThrowsAttempted;
    private double freeThrowPercentage;
    private int practiceNumber;
    private String date;


    

    
}
