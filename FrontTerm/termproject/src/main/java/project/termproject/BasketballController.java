package project.termproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/basketball_api/v1/")
public class BasketballController {
    
    @Autowired
    private PlayerService playerService;
    @Autowired
    private FreeThrowService freeThrowService;
    @Autowired
    private ThreePointService threePointService;

    public BasketballController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @PostMapping("/addPlayer")
    public PlayerModel addPlayer(@RequestBody PlayerModel player) {
        
        return playerService.addPlayer(player);
    }

    @PostMapping("/editPlayer")
    public PlayerModel editPlayer(@RequestBody PlayerModel player) {
        
        return playerService.editPlayer(player);
    }

    @PostMapping("/addFreeThrow")
    public FreeThrowModel addFreeThrow(@RequestBody FreeThrowModel freeThrow) {
        
        return freeThrowService.addFreeThrow(freeThrow);
    }

    @PostMapping("/editFreeThrow")
    public FreeThrowModel editFreeThrow(@RequestBody FreeThrowModel freeThrow) {
        
        return freeThrowService.editFreeThrow(freeThrow);
    }

    @PostMapping("/addThreePoint")
    public ThreePointModel addThreePoint(@RequestBody ThreePointModel threePoint) {
        
        return threePointService.addThreePoint(threePoint);
    }

    @PostMapping("/editThreePoint")
    public ThreePointModel editThreePoint(@RequestBody ThreePointModel threePoint) {
        
        return threePointService.editThreePoint(threePoint);
    }


    
   


}
