package project.termproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/basketball_api/")
public class BasketballController {
    
    @Autowired
    private PlayerService playerService;
    @Autowired
    private FreeThrowService freeThrowService;
    @Autowired
    private ThreePointService threePointService;

    public BasketballController(PlayerService playerService, FreeThrowService freeThrowService, ThreePointService threePointService) {
        this.playerService = playerService;
        this.freeThrowService = freeThrowService;
        this.threePointService = threePointService;
    }

    @GetMapping("/getPlayers")
    public List<PlayerModel> getPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/getLatestPlayer")
    public PlayerModel getLatestPlayer() {
        return playerService.getLatestPlayer();
    }
    
    @PostMapping("/addPlayer")
    public PlayerModel addPlayer(@RequestBody PlayerModel player) {
        
        return playerService.addPlayer(player);
    }

    @PutMapping("/editPlayer")
    public PlayerModel editPlayer(@RequestBody PlayerModel player) {
        
        return playerService.editPlayer(player);
    }

    @PostMapping("/addFreeThrow")
    public FreeThrowModel addFreeThrow(@RequestBody FreeThrowModel freeThrow) {
        
        return freeThrowService.addFreeThrow(freeThrow);
    }

    @PutMapping("/editFreeThrow")
    public FreeThrowModel editFreeThrow(@RequestBody FreeThrowModel freeThrow) {
        
        return freeThrowService.editFreeThrow(freeThrow);
    }

    @GetMapping("/getFreeThrows")
    public List<FreeThrowModel> getFreeThrows() {
        return freeThrowService.getAllFreeThrows();
    }

    @GetMapping("/getLatestFreeThrow")
    public FreeThrowModel getLatestFreeThrow() {
        return freeThrowService.getLatestFreeThrow();
    }

    @PostMapping("/addThreePoint")
    public ThreePointModel addThreePoint(@RequestBody ThreePointModel threePoint) {
        
        return threePointService.addThreePoint(threePoint);
    }

    @PutMapping("/editThreePoint")
    public ThreePointModel editThreePoint(@RequestBody ThreePointModel threePoint) {
        
        return threePointService.editThreePoint(threePoint);
    }

    @GetMapping("/getThreePoints")
    public List<ThreePointModel> getThreePoints() {
        return threePointService.getAllThreePoints();
    }

    @GetMapping("/getLatestThreePointer")
    public ThreePointModel getLatestThreePointer() {
        return threePointService.getLatestThreePointer();
    }


    
   


}
