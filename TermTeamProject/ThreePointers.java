/*
 * This class is a subclass of the PracticeShots class. It is used
 * to keep track of the number of three pointers made and attempted
 * by a player. The class contains the following methods:
 * - getShotsMade
 * - setShotsMade
 * - getShotsAttempted
 * - setShotsAttempted
 * - getShootingPercentage
 * The class contains a default constructor, a constructor with parameters, and getter and setter methods for each field.
 * The class also contains a toString method to return the fields of the object as a string.
 * The class extends the PracticeShots class.
 */

public class ThreePointers extends PracticeShots{
    private int threePointersMade;
    private int threePointersAttempted;

    /*
     * Default constructor for ThreePointers class.
     * Initializes all fields to default values.
     * The default values are 0 for both fields.
     * The constructor calls the constructor of the superclass.
     * The constructor also initializes the threePointersMade and threePointersAttempted fields to 0.
     */
    public ThreePointers() {
        threePointersMade = 0;
        threePointersAttempted = 0;
        
    }

    /*
     * Constructor for ThreePointers class.
     * Initializes all fields to the values passed as parameters.
     * @param threePointersMade
     * @param threePointersAttempted
     */
    public ThreePointers(int threePointersMade, int threePointersAttempted){
        this.threePointersMade = threePointersMade;
        this.threePointersAttempted = threePointersAttempted;
    }
    
    /*
     * Getter method for threePointersMade field.
     * @return threePointersMade
     */
    @Override
    public int getShotsMade() {
        return threePointersMade;
    }

    /*
     * Setter method for threePointersMade field.
     * @param threePointersMade
     */
    @Override
    public void setShotsMade(int threePointersMade) {
        this.threePointersMade = threePointersMade;
    }

    /*
     * Getter method for threePointersAttempted field.
     * @return threePointersAttempted
     */
    @Override
    public int getShotsAttempted() {
        return threePointersAttempted;
    }

    /*
     * Setter method for threePointersAttempted field.
     * @param threePointersAttempted
     */
    @Override
    public void setShotsAttempted(int threePointersAttempted) {
        this.threePointersAttempted = threePointersAttempted;
    }

    /*
     * This method is used to calculate the shooting percentage of a player.
     * The method returns the shooting percentage as a double.
     * The method divides the number of three pointers made by the number of three pointers attempted.
     * @return shootingPercentage
     */
    @Override
    public double getShootingPercentage() {
        return (double) threePointersMade / threePointersAttempted;
    }
    
}
