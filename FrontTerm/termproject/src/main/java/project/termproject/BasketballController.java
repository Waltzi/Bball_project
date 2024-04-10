package project.termproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.termproject.PlayerRepository; // Add the missing import statement
import project.termproject.PlayerEntity; // Add the missing import statement
import org.springframework.web.bind.annotation.RequestParam;
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
