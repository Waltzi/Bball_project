package project.termproject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    
}
