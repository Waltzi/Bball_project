package project.termproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long>{
    // You can add custom query methods here if needed
    
    
}
