package project.termproject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long>{
    // You can add custom query methods here if needed
    
    
}
