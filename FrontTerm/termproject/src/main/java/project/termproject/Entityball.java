// SpringBootBasketballApplication.java
import org.springframework.boot.SpringApplication
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

@SpringBootApplication
public class SpringBootBasketballApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasketballApplication.class, args);
    }
}

// Player.java
@Entity
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    // Add other fields as needed
    
    // Getters and setters
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
    public String index(Model model) {
        model.addAttribute("players", playerRepository.findAll());
        return "index";
    }
    
    // Add other controller methods as needed
}
