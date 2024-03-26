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
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.termproject.PlayerRepository; // Add the missing import statement


@Controller
public class BasketballController {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("players", playerRepository.findAll());
        return "index";
    }

    // Add other controller methods as needed
    

}
