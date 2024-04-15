package project.termproject;

import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ThreePointServiceImpl implements ThreePointService{
    
    private ThreePointRepository threePointRepository;

    public ThreePointServiceImpl(ThreePointRepository threePointRepository) {
        this.threePointRepository = threePointRepository;
    }

    @Override
    public ThreePointModel addThreePoint(ThreePointModel threePoint) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = date.format(dateFormatter);
        threePoint.setDate(formattedDate);

        ThreePointEntity threePointEntity = new ThreePointEntity();
        if (threePoint != null) {
            BeanUtils.copyProperties(threePoint, threePointEntity);
        }
        threePointRepository.save(threePointEntity);
        return threePoint;
    }

    @Override
    public ThreePointModel editThreePoint(ThreePointModel threePoint) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = date.format(dateFormatter);
        threePoint.setDate(formattedDate);

        ThreePointEntity threePointEntity = threePointRepository.findById(threePoint.getId()).get();
        if (threePointEntity != null) {
            BeanUtils.copyProperties(threePoint, threePointEntity);
            threePointRepository.save(threePointEntity);
        }
        return threePoint;
    }
    
}
