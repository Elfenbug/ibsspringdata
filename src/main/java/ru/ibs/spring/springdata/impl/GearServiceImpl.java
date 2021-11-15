package ru.ibs.spring.springdata.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.spring.springdata.dao.GearRepository;
import ru.ibs.spring.springdata.entity.Gear;
import ru.ibs.spring.springdata.service.GearService;

import java.util.List;

@Service
public class GearServiceImpl implements GearService {

    @Autowired
    private GearRepository gearRepository;

    @Override
    public List<Gear> getAllGears() {
        return gearRepository.findAll();
    }

    @Override
    public void saveGear(Gear gear) {
        gearRepository.save(gear);
    }

    @Override
    public Gear getGear(Long id) {
        return gearRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteGear(Long id) {
        gearRepository.deleteById(id);
    }

    @Override
    public void updateGear(Gear gear, Long id) {
        if (gearRepository.findById(id).orElse(null) != null) {
            gear.setId(id);
            gearRepository.save(gear);
        }
    }
}

//    @Override
//    public Gear findGear(Car car) {
//
//        return gearRepository.findGearByEngineId(car.getEngine().getId());
//    }
//
//    @Override
//    public List<Gear> findGears(Car car) {
//        return gearRepository.findGearsByEngineId(car.getEngine().getId());
//    }
