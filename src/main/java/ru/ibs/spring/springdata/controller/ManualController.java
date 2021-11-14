package ru.ibs.spring.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.spring.springdata.entity.Manual;
import ru.ibs.spring.springdata.exception_handling.NoSuchElementException;
import ru.ibs.spring.springdata.service.ManualService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManualController {

    @Autowired
    private ManualService manualService;

    @GetMapping("/manual/read")
    public List<Manual> showAllManuals() {
        List<Manual> allManuals = manualService.getAllManuals();
        return allManuals;
    }

    @GetMapping("/manual/read/{id}")
    public Manual getManual(@PathVariable Long id) {
        Manual manual = manualService.getManual(id);
        return manual;
    }

    @PostMapping("/manual/create")
    public Manual addNewManual(@RequestBody Manual manual) {
        manualService.saveManual(manual);
        return manual;
    }

    @PostMapping("/manual/update/{id}")
    public Manual updateManual(@RequestBody Manual manual, @PathVariable Long id) {
        manualService.updateManual(manual, id);
        return manual;
    }

    @PostMapping("/manual/update")
    public Manual updateManual() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/manual/delete/{id}")
    public String deleteManual(@PathVariable Long id) {
        manualService.deleteManual(id);
        return "Manual with ID = " + id + "was deleted";
    }

    @PostMapping("/manual/delete/")
    public String noIdToDelete(@PathVariable Long id) {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
