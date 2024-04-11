package project.termproject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FreeThrowServiceImpl implements FreeThrowService{
    
    private FreeThrowRepository freeThrowRepository;

    public FreeThrowServiceImpl(FreeThrowRepository freeThrowRepository) {
        this.freeThrowRepository = freeThrowRepository;
    }

    @Override
    public FreeThrowModel addFreeThrow(FreeThrowModel freeThrow) {
        FreeThrowEntity freeThrowEntity = new FreeThrowEntity();
        if (freeThrow != null) {
            BeanUtils.copyProperties(freeThrow, freeThrowEntity);
        }
        freeThrowRepository.save(freeThrowEntity);
        return freeThrow;
    }

    @Override
    public FreeThrowModel editFreeThrow(FreeThrowModel freeThrow) {
        FreeThrowEntity freeThrowEntity = new FreeThrowEntity();
        if (freeThrow != null) {
            BeanUtils.copyProperties(freeThrow, freeThrowEntity);
        }
        freeThrowRepository.save(freeThrowEntity);
        return freeThrow;
    }
    
}
