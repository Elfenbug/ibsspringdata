package ru.ibs.spring.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.spring.springdata.entity.Car;
import ru.ibs.spring.springdata.entity.Gear;
import ru.ibs.spring.springdata.exception_handling.NoSuchElementException;
import ru.ibs.spring.springdata.service.GearService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GearController {

    @Autowired
    private GearService gearService;

    @GetMapping("/gear/read")
    public List<Gear> showAllGear() {
        List<Gear> allGears = gearService.getAllGears();
        return allGears;
    }

    @GetMapping("/gear/read/{id}")
    public Gear getGear(@PathVariable Long id) {
        Gear gear = gearService.getGear(id);
        return gear;
    }

    @PostMapping("/gear/create")
    public Gear addNewGear(@RequestBody Gear gear) {
        gearService.saveGear(gear);
        return gear;
    }

    @PostMapping("/gear/update/{id}")
    public Gear updateGear(@RequestBody Gear gear, @PathVariable Long id) {
        gearService.updateGear(gear, id);
        return gear;
    }

    @PostMapping("/gear/update")
    public Car updateCar() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/gear/delete/{id}")
    public String deleteGear(@PathVariable Long id) {
        gearService.deleteGear(id);
        return "Gear with ID = " + id + "was deleted";
    }

    @PostMapping("/gear/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
