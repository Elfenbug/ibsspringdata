package ru.ibs.spring.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.spring.springdata.entity.Gear;
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

    @PutMapping("/gear/update")
    public Gear updateGear(@RequestBody Gear gear) {
        gearService.saveGear(gear);
        return gear;
    }

    @DeleteMapping("/gear/delete/{id}")
    public String deleteGear(@PathVariable Long id) {
        gearService.deleteGear(id);
        return "Gear with ID = " + id + "was deleted";
    }
}
