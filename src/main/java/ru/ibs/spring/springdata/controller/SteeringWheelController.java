package ru.ibs.spring.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.spring.springdata.entity.SteeringWheel;
import ru.ibs.spring.springdata.exception_handling.NoSuchElementException;
import ru.ibs.spring.springdata.service.SteeringWheelService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SteeringWheelController {

    @Autowired
    private SteeringWheelService steeringWheelService;

    @GetMapping("/steeringwheel/read")
    public List<SteeringWheel> showAllSteeringWheel() {
        List<SteeringWheel> allSteeringWheels = steeringWheelService.getAllSteeringWheels();
        return allSteeringWheels;
    }

    @GetMapping("/steeringwheel/read/{id}")
    public SteeringWheel getSteeringWheel(@PathVariable Long id) {
        SteeringWheel steeringWheel = steeringWheelService.getSteeringWheel(id);
        return steeringWheel;
    }

    @PostMapping(value = "/steeringwheel/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SteeringWheel addNewSteeringWheel(@RequestBody SteeringWheel steeringWheel) {
        steeringWheelService.saveSteeringWheel(steeringWheel);
        return steeringWheel;
    }

    @PostMapping("/steeringwheel/update/{id}")
    public void updateSteeringWheel(@RequestBody SteeringWheel steeringWheel, @PathVariable Long id) {
        steeringWheelService.updateSteerlingWheel(steeringWheel, id);
    }

    @PostMapping("/steeringwheel/update")
    public SteeringWheel updateSteeringWheel() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/steeringwheel/delete/{id}")
    public String deleteSteeringWheel(@PathVariable Long id) {
        steeringWheelService.deleteSteeringWheel(id);
        return "SteeringWheel with ID = " + id + "was deleted";
    }

    @PostMapping("/steeringwheel/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
