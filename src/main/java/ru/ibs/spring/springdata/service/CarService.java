package ru.ibs.spring.springdata.service;

import ru.ibs.spring.springdata.entity.Car;

import java.util.List;

public interface CarService {
    //Car addCar(String mnfName, String modelName, String engineType);

    List<Car> getAllCars();

    void saveCar(Car car);

    Car getCar(Long id);

    void deleteCar(Long id);

    void updateCar(Car car, Long id);
}
