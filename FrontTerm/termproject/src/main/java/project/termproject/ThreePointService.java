package project.termproject;

import java.util.List;

public interface ThreePointService {
    ThreePointModel addThreePoint(ThreePointModel threePoint);
    ThreePointModel editThreePoint(ThreePointModel threePoint);
    List<ThreePointModel> getAllThreePoints();
    ThreePointModel getLatestThreePointer();
} 
