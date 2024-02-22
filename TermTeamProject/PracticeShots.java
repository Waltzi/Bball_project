/*
 * PracticeShots.java
 * This file contains the abstract class PracticeShots
 * The class contains the following abstract methods:
 * - getShotsMade
 * - setShotsMade
 * - getShotsAttempted
 * - setShotsAttempted
 * - getShootingPercentage
 */

public abstract class PracticeShots {
    
    /**
     * Abstract method to get the number of shots made.
     * @return shotsMade
     */
    public abstract int getShotsMade();

    /**
     * Abstract method to set the number of shots made.
     * @param shotsMade
     */
    public abstract void setShotsMade(int shotsMade);

    /**
     * Abstract method to get the number of shots attempted.
     * @return shotsAttempted
     */
    public abstract int getShotsAttempted();

    /**
     * Abstract method to set the number of shots attempted.
     * @param shotsAttempted
     */
    public abstract void setShotsAttempted(int shotsAttempted);

    /**
     * Abstract method to get the shooting percentage.
     * @return shootingPercentage
     */
    public abstract double getShootingPercentage();
    
}
