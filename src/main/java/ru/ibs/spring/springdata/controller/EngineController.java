package ru.ibs.spring.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.spring.springdata.entity.Engine;
import ru.ibs.spring.springdata.exception_handling.NoSuchElementException;
import ru.ibs.spring.springdata.service.EngineService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EngineController {

    @Autowired
    private EngineService engineService;

    @GetMapping("/engine/read")
    public List<Engine> showAllEngines() {
        List<Engine> allEngines = engineService.getAllEngines();
        return allEngines;
    }

    @GetMapping("/engine/read/{id}")
    public Engine getEngine(@PathVariable Long id) {
        Engine engine = engineService.getEngine(id);
        return engine;
    }

    @PostMapping("/engine/create")
    public Engine addNewEngine(@RequestBody Engine engine) {
        engineService.saveEngine(engine);
        return engine;
    }

    @PostMapping("/engine/update/{id}")
    public void updateEngine(@RequestBody Engine engine, @PathVariable Long id) {
        engineService.updateEngine(engine, id);
    }

    @PostMapping("/engine/update/")
    public Engine updateEngine() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/engine/delete/{id}")
    public String deleteEngine(@PathVariable Long id) {
        engineService.deleteEngine(id);
        return "Engine with ID = " + id + "was deleted";
    }

    @PostMapping("/engine/delete/")
    public String noIDtoDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
