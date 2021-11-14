package ru.ibs.spring.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.spring.springdata.dao.SteeringWheelRepository;
import ru.ibs.spring.springdata.entity.SteeringWheel;

import java.util.List;
import java.util.Optional;

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
        SteeringWheel steeringWheel = null;
        Optional<SteeringWheel> optional = steeringWheelRepository.findById(id);
        if(optional.isPresent()) {
            steeringWheel = optional.get();
        }
        return steeringWheel;
    }

    @Override
    public void deleteSteeringWheel(Long id) {
        steeringWheelRepository.deleteById(id);
    }
}
