package ru.ibs.spring.springdata.service;

import ru.ibs.spring.springdata.entity.SteeringWheel;

import java.util.List;

public interface SteeringWheelService {

    List<SteeringWheel> getAllSteeringWheels();

    void saveSteeringWheel(SteeringWheel steeringWheel);

    SteeringWheel getSteeringWheel(Long id);

    void deleteSteeringWheel(Long id);
}
