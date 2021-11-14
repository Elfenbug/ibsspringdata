package ru.ibs.spring.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.spring.springdata.dao.ManualRepository;
import ru.ibs.spring.springdata.entity.Manual;

import java.util.List;
import java.util.Optional;

@Service
public class ManualServiceImpl implements ManualService{

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
        Manual manual = null;
        Optional<Manual> optional = manualRepository.findById(id);
        if(optional.isPresent()) {
            manual = optional.get();
        }
        return manual;
    }

    @Override
    public void deleteManual(Long id) {
        manualRepository.deleteById(id);
    }

    @Override
    public void updateManual(Manual manual, Long id) {
        Optional<Manual> optional = manualRepository.findById(id);
        if (optional.isPresent()) {
            manual = optional.get();
        }
        manualRepository.save(manual);
    }
}
