package ru.ibs.spring.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.spring.springdata.dao.EngineRepository;
import ru.ibs.spring.springdata.entity.Engine;

import java.util.List;
import java.util.Optional;

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
        Engine engine = null;
        Optional<Engine> optional = engineRepository.findById(id);
        if(optional.isPresent()) {
            engine = optional.get();
        }
        return engine;
    }

    @Override
    public void deleteEngine(Long id) {
        engineRepository.deleteById(id);
    }

    @Override
    public void updateEngine(Engine engine, Long id) {
        Optional<Engine> optional = engineRepository.findById(id);
        if (optional.isPresent()) {
            engine = optional.get();
        }
        engineRepository.save(engine);
    }
}
