package ru.ibs.spring.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.spring.springdata.entity.Car;
import ru.ibs.spring.springdata.exception_handling.NoSuchElementException;
import ru.ibs.spring.springdata.service.CarService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/car/read")
    public List<Car> showAllCars() {
        List<Car> allCars = carService.getAllCars();
        return allCars;
    }

    @GetMapping("/car/read/{id}")
    public Car getCar(@PathVariable Long id) {
        Car car = carService.getCar(id);
        return car;
    }

    @PostMapping("/car/create")
    public Car addNewCar(@RequestBody Car car) {
        carService.saveCar(car);
        return car;
    }

    @PostMapping("/car/update/{id}")
    public Car updateCar(@PathVariable Long id) {
        if (id == null) {
            throw new NoSuchElementException("No element with id = " + id);
        }
        Car car = carService.getCar(id);
        carService.saveCar(car);
        return car;
    }

    @PostMapping("/car/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        Car car = carService.getCar(id);
        if (car == null) {
            throw new NoSuchElementException("No element with id = " + id);
        }
        carService.deleteCar(id);
        return "Car with ID = " + id + " was deleted";
    }

    @PostMapping("/car/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
