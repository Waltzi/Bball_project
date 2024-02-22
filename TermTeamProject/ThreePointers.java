public class ThreePointers extends PracticeShots{
    private int threePointersMade;
    private int threePointersAttempted;

    public ThreePointers() {
        threePointersMade = 0;
        threePointersAttempted = 0;
        
    }

    public ThreePointers(int threePointersMade, int threePointersAttempted){
        this.threePointersMade = threePointersMade;
        this.threePointersAttempted = threePointersAttempted;
    }
    
    @Override
    public int getShotsMade() {
        return threePointersMade;
    }

    @Override
    public void setShotsMade(int threePointersMade) {
        this.threePointersMade = threePointersMade;
    }

    @Override
    public int getShotsAttempted() {
        return threePointersAttempted;
    }

    @Override
    public void setShotsAttempted(int threePointersAttempted) {
        this.threePointersAttempted = threePointersAttempted;
    }

    @Override
    public double getShootingPercentage() {
        return (double) threePointersMade / threePointersAttempted;
    }
    
}
