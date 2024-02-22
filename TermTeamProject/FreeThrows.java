/*
 * FreeThrows.java
 * This file contains the FreeThrows class
 * The class contains the following methods:
 * - getShotsMade
 * - setShotsMade
 * - getShotsAttempted
 * - setShotsAttempted
 * - getShootingPercentage
 * The class contains a default constructor, a constructor with parameters, and getter and setter methods for each field.
 * The class also contains a toString method to return the fields of the object as a string.
 * The class extends the PracticeShots class.
 */

public class FreeThrows extends PracticeShots{
    private int freeThrowsMade;
    private int freeThrowsAttempted;

    /*
     * Default constructor for FreeThrows class.
     * Initializes all fields to default values.
     * The default values are 0 for both fields.
     * The constructor calls the constructor of the superclass.
     * The constructor also initializes the freeThrowsMade and freeThrowsAttempted fields to 0.
     */
    public FreeThrows() {
        freeThrowsMade = 0;
        freeThrowsAttempted = 0;
        
    }

    /*
     * Constructor for FreeThrows class.
     * Initializes all fields to the values passed as parameters.
     * @param freeThrowsMade
     * @param freeThrowsAttempted
     */
    public FreeThrows(int freeThrowsMade, int freeThrowsAttempted){
        this.freeThrowsMade = freeThrowsMade;
        this.freeThrowsAttempted = freeThrowsAttempted;
    }
    
    /*
     * Getter method for freeThrowsMade field.
     * @return freeThrowsMade
     */
    @Override
    public int getShotsMade() {
        return freeThrowsMade;
    }

    /*
     * Setter method for freeThrowsMade field.
     * @param freeThrowsMade
     */
    @Override
    public void setShotsMade(int freeThrowsMade) {
        this.freeThrowsMade = freeThrowsMade;
    }

    /*
     * Getter method for freeThrowsAttempted field.
     * @return freeThrowsAttempted
     */
    @Override
    public int getShotsAttempted() {
        return freeThrowsAttempted;
    }

    /*
     * Setter method for freeThrowsAttempted field.
     * @param freeThrowsAttempted
     */
    @Override
    public void setShotsAttempted(int freeThrowsAttempted) {
        this.freeThrowsAttempted = freeThrowsAttempted;
    }

    /*
     * Getter method for shooting percentage.
     * @return shootingPercentage
     */
    @Override
    public double getShootingPercentage() {
        return (double) freeThrowsMade / freeThrowsAttempted;
    }

}
