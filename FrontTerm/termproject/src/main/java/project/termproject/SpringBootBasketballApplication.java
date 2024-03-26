// SpringBootBasketballApplication.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

@SpringBootApplication
public class SpringBootBasketballApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasketballApplication.class, args);
    }
}

// PlayerRepository.java
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // You can add custom query methods here if needed
}

// BasketballController.java
@Controller
public class BasketballController {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @GetMapping("/")
    public String getAllPlayers(Model model) {
        model.addAttribute("players", playerRepository.findAll());
        return "index"; // return the name of the view
    }

    // Add more methods as needed
}