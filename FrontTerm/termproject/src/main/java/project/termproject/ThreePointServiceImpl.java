package project.termproject;

import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
        List<ThreePointEntity> threePointEntities = threePointRepository.findAll();

        // Sort freeThrowEntities in descending order of practiceNum
        threePointEntities.sort((e1, e2) -> e2.getPracticeNum() - e1.getPracticeNum());

        boolean matchFound = false;
        for (ThreePointEntity threePointEntity1 : threePointEntities) {
            String date1 = threePointEntity1.getDate();
            if (date1.equals(threePoint.getDate()) && threePointEntity1.getJerseyNumber() == threePoint.getJerseyNumber()){
                // If there's an existing free throw with the same date and jersey number, increment practiceNum
                threePoint.setPracticeNum(threePointEntity1.getPracticeNum() + 1);
                matchFound = true;
                break;
            }
        }

        if (!matchFound) {
            // If no match was found, set practiceNum to 1
            threePoint.setPracticeNum(1);
        }

        if (threePoint != null) {
            BeanUtils.copyProperties(threePoint, threePointEntity);
            threePointRepository.save(threePointEntity);
        }
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

    @Override
    public List<ThreePointModel> getAllThreePoints() {
        List<ThreePointEntity> threePointEntities = threePointRepository.findAll();
        List<ThreePointModel> threePointModels = new ArrayList<>();
        for (ThreePointEntity threePointEntity : threePointEntities) {
            ThreePointModel threePointModel = new ThreePointModel();
            BeanUtils.copyProperties(threePointEntity, threePointModel);
            threePointModels.add(threePointModel);
        }
        return threePointModels;
    }

    @Override
    public ThreePointModel getLatestThreePointer() {
        List<ThreePointEntity> threePointEntities = threePointRepository.findAll();
        ThreePointModel threePointModel = new ThreePointModel();
        if (threePointEntities.size() > 0) {
            ThreePointEntity threePointEntity = threePointEntities.get(threePointEntities.size() - 1);
            BeanUtils.copyProperties(threePointEntity, threePointModel);
        }
        return threePointModel;
    }
    
}
