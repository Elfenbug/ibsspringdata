package ru.ibs.spring.springdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.spring.springdata.dao.ManualRepository;
import ru.ibs.spring.springdata.entity.Manual;
import ru.ibs.spring.springdata.service.ManualService;

import java.util.List;

@Service
public class ManualServiceImpl implements ManualService {

    @Autowired
    ManualRepository manualRepository;

    @Override
    public List<Manual> getAllManuals() {
        return manualRepository.findAll();
    }

    @Override
    public void saveManual(Manual manual) {
        manualRepository.save(manual);
    }

    @Override
    public Manual getManual(Long id) {
        return manualRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteManual(Long id) {
        manualRepository.deleteById(id);
    }

    @Override
    public void updateManual(Manual manual, Long id) {
        if (manualRepository.findById(id).orElse(null) != null) {
            manual.setId(id);
            manualRepository.save(manual);
        }
    }
}
