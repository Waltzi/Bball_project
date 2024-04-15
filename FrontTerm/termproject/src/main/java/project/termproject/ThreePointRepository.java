package project.termproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreePointRepository extends JpaRepository<ThreePointEntity, Long>{
    
}
