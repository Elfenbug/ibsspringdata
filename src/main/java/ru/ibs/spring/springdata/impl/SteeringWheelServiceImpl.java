package ru.ibs.spring.springdata.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.spring.springdata.dao.SteeringWheelRepository;
import ru.ibs.spring.springdata.entity.SteeringWheel;
import ru.ibs.spring.springdata.service.SteeringWheelService;

import java.util.List;

@Service
public class SteeringWheelServiceImpl implements SteeringWheelService {

    @Autowired
    SteeringWheelRepository steeringWheelRepository;

    @Override
    public List<SteeringWheel> getAllSteeringWheels() {
        return steeringWheelRepository.findAll();
    }

    @Override
    public void saveSteeringWheel(SteeringWheel steeringWheel) {
        steeringWheelRepository.save(steeringWheel);
    }

    @Override
    public SteeringWheel getSteeringWheel(Long id) {
        return steeringWheelRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSteeringWheel(Long id) {
        steeringWheelRepository.deleteById(id);
    }

    @Override
    public void updateSteerlingWheel(SteeringWheel steeringWheel, Long id) {
        if (steeringWheelRepository.findById(id).orElse(null) != null) {
            steeringWheel.setId(id);
            steeringWheelRepository.save(steeringWheel);
        }
    }
}
