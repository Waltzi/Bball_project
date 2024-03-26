package project.termproject;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.persistence.Entity;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    private String position;
    private int number;
    private int classYear;

    // Constructors
    /**
     * Default constructor for Player class.
     */
    public Player() {
        this.firstName = "";
        this.lastName = "";
        this.position = "";
        this.number = 0;
        this.classYear = 0;
    }
    
    // Getters and setters
    /**
     * Getter method for id field.
     * @return id
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter method for lastName field.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Getter method for position field.
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Getter method for number field.
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Getter method for classYear field.
     * @return classYear
     */
    public int getClassYear() {
        return classYear;
    }

    /**
     * Setter method for firstName and lastName fields.
     * @param firstName
     * @param lastName
     */
    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Setter method for position field.
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Setter method for number field.
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Setter method for classYear field.
     * @param classYear
     */
    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }
=======
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
>>>>>>> 81390bbf3212164585a2ada021e195a9a5db0364
    
}
