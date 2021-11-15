package ru.ibs.spring.springdata.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.spring.springdata.dao.EngineRepository;
import ru.ibs.spring.springdata.entity.Engine;
import ru.ibs.spring.springdata.service.EngineService;

import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {

    @Autowired
    EngineRepository engineRepository;


    @Override
    public List<Engine> getAllEngines() {
        return engineRepository.findAll();
    }

    @Override
    public void saveEngine(Engine engine) {
        engineRepository.save(engine);
    }

    @Override
    public Engine getEngine(Long id) {
        return engineRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEngine(Long id) {
        engineRepository.deleteById(id);
    }

    @Override
    public void updateEngine(Engine engine, Long id) {
        if (engineRepository.findById(id).orElse(null) != null) {
            engine.setId(id);
            engineRepository.save(engine);
        }
    }
}
