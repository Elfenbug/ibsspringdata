package ru.ibs.spring.springdata.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.spring.springdata.entity.*;
import ru.ibs.spring.springdata.dao.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car getCar(Long id) {
        Car car = null;
        Optional<Car> optional = carRepository.findById(id);
        if (optional.isPresent()) {
            car = optional.get();
        }
        return car;
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void updateCar(Car car, Long id) {
        Optional<Car> optional = carRepository.findById(id);
        if (optional.isPresent()) {
            car = optional.get();
        }
        carRepository.save(car);
    }


//    @Override
//    public Car addCar(String mnfName, String modelName, String engineType) {
//        final Car newCar = new Car(mnfName, modelName);
//
//        final SteeringWheel steeringWheel = new SteeringWheel(String.join(" ", newCar.getManufacturerName(),newCar.getModelName(),"steering wheel"));
//        newCar.setSteeringWheel(steeringWheel);
//
//        Engine engine = new Engine(engineType);
//        for (int i = 5; i <= 10; i++) {
//            final Gear gear = new Gear(i);
//            gear.setEngine(engine);
//            engine.getGears().add(gear);
//        }
//        newCar.setEngine(engine);
//
//        Manual cylinderHeadManual = new Manual("Cylinder head manual for " + engineType);
//        engine.getManuals().add(cylinderHeadManual);
//        cylinderHeadManual.getEngines().add(engine);
//        Manual electricManual = new Manual("Electrics manual for " + engineType);
//        engine.getManuals().add(electricManual);
//        electricManual.getEngines().add(engine);
//
//        return carRepository.save(newCar);
//    }
}
