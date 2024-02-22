public class FreeThrows extends PracticeShots{
    private int freeThrowsMade;
    private int freeThrowsAttempted;

    public FreeThrows() {
        freeThrowsMade = 0;
        freeThrowsAttempted = 0;
        
    }

    public FreeThrows(int freeThrowsMade, int freeThrowsAttempted){
        this.freeThrowsMade = freeThrowsMade;
        this.freeThrowsAttempted = freeThrowsAttempted;
    }
    
    @Override
    public int getShotsMade() {
        return freeThrowsMade;
    }

    @Override
    public void setShotsMade(int freeThrowsMade) {
        this.freeThrowsMade = freeThrowsMade;
    }

    @Override
    public int getShotsAttempted() {
        return freeThrowsAttempted;
    }

    @Override
    public void setShotsAttempted(int freeThrowsAttempted) {
        this.freeThrowsAttempted = freeThrowsAttempted;
    }

    @Override
    public double getShootingPercentage() {
        return (double) freeThrowsMade / freeThrowsAttempted;
    }

}
