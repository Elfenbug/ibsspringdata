package ru.ibs.spring.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.spring.springdata.entity.SteeringWheel;
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

    @PostMapping(value ="/steeringwheel/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SteeringWheel addNewSteeringWheel(@RequestBody SteeringWheel steeringWheel) {
        steeringWheelService.saveSteeringWheel(steeringWheel);
        return steeringWheel;
    }

    @PutMapping("/steeringwheel/update")
    public SteeringWheel updateSteeringWheel(@RequestBody SteeringWheel steeringWheel) {
        steeringWheelService.saveSteeringWheel(steeringWheel);
        return steeringWheel;
    }

    @DeleteMapping("/steeringwheel/delete/{id}")
    public String deleteSteeringWheel(@PathVariable Long id) {
        steeringWheelService.deleteSteeringWheel(id);
        return "SteeringWheel with ID = " + id + "was deleted";
    }
}
