package project.termproject;

import java.util.List; // Import the correct List class

public interface FreeThrowService {
    FreeThrowModel addFreeThrow(FreeThrowModel freeThrow);
    FreeThrowModel editFreeThrow(FreeThrowModel freeThrow);
    List<FreeThrowModel> getAllFreeThrows();
    FreeThrowModel getLatestFreeThrow();
    
} 
