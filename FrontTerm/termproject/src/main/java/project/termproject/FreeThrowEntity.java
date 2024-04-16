package project.termproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "FreeThrows")
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

    public void setDate(String date) {
        this.date = date;
    }
    
}
