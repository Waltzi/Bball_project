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

    @GetMapping("/add player")
    public String create(Model model) {
        model.addAttribute("player", new Player());
        return "added player";
    }

    @PostMapping("/save")
    public String save(Player player) {
        playerRepository.save(player);
        return "redirect:/";
    }

    @GetMapping("/edit/{number}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerRepository.findByNumber(jerseyNumber).orElse(new Player()));
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, Player player) {
        playerRepository.save(player);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        playerRepository.deleteById(id);
        return "redirect:/";
    }


}
