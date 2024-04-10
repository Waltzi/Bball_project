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

    public BasketballController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @PostMapping("/Roster")
    public PlayerModel addPlayer(@RequestBody PlayerModel player) {
        
        return playerService.addPlayer(player);
    }

    
   


}
