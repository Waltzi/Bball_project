package project.termproject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FreeThrowServiceImpl implements FreeThrowService{
    
    private FreeThrowRepository freeThrowRepository;

    public FreeThrowServiceImpl(FreeThrowRepository freeThrowRepository) {
        this.freeThrowRepository = freeThrowRepository;
    }

    @Override
    public FreeThrowModel addFreeThrow(FreeThrowModel freeThrow) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = date.format(dateFormatter);
        freeThrow.setDate(formattedDate);

        double freeThrowPercentage = (double) freeThrow.getFreeThrowsMade() / freeThrow.getFreeThrowsAttempted();
        freeThrowPercentage = Double.parseDouble(String.format("%.2f", freeThrowPercentage));
        freeThrow.setFreeThrowPercentage(freeThrowPercentage);

        FreeThrowEntity freeThrowEntity = new FreeThrowEntity();
        if (freeThrow != null) {
            BeanUtils.copyProperties(freeThrow, freeThrowEntity);
        }
        freeThrowRepository.save(freeThrowEntity);
        return freeThrow;
    }

    @Override
    public FreeThrowModel editFreeThrow(FreeThrowModel freeThrow) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = date.format(dateFormatter);
        freeThrow.setDate(formattedDate);
        
        FreeThrowEntity freeThrowEntity = freeThrowRepository.findById(freeThrow.getId()).get();
        if (freeThrowEntity != null) {
            BeanUtils.copyProperties(freeThrow, freeThrowEntity);
            freeThrowRepository.save(freeThrowEntity);
        }
        return freeThrow;
    }

    @Override
    public List<FreeThrowModel> getAllFreeThrows() {
        List<FreeThrowEntity> freeThrowEntities = freeThrowRepository.findAll();
        List<FreeThrowModel> freeThrowModels = new ArrayList<>();
        for (FreeThrowEntity freeThrowEntity : freeThrowEntities) {
            FreeThrowModel freeThrowModel = new FreeThrowModel();
            BeanUtils.copyProperties(freeThrowEntity, freeThrowModel);
            freeThrowModels.add(freeThrowModel);
        }
        return freeThrowModels;
    }

    @Override
    public FreeThrowModel getLatestFreeThrow() {
        List<FreeThrowEntity> freeThrowEntities = freeThrowRepository.findAll();
        FreeThrowModel freeThrowModel = new FreeThrowModel();
        if (freeThrowEntities.size() > 0) {
            FreeThrowEntity freeThrowEntity = freeThrowEntities.get(freeThrowEntities.size() - 1);
            BeanUtils.copyProperties(freeThrowEntity, freeThrowModel);
        }
        return freeThrowModel;
    }
    
}
