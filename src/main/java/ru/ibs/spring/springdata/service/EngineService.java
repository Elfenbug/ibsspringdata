package ru.ibs.spring.springdata.service;

import ru.ibs.spring.springdata.entity.Engine;

import java.util.List;

public interface EngineService {

    List<Engine> getAllEngines();

    void saveEngine(Engine engine);

    Engine getEngine(Long id);

    void deleteEngine(Long id);

    void updateEngine(Engine engine, Long id);
}
