package ru.ibs.spring.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.spring.springdata.dao.GearRepository;
import ru.ibs.spring.springdata.entity.Gear;

import java.util.List;
import java.util.Optional;

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
        Gear gear = null;
        Optional<Gear> optional = gearRepository.findById(id);
        if (optional.isPresent()) {
            gear = optional.get();
        }
        return gear;
    }

    @Override
    public void deleteGear(Long id) {
        gearRepository.deleteById(id);
    }

    @Override
    public void updateGear(Gear gear, Long id) {
        Optional<Gear> optional = gearRepository.findById(id);
        if (optional.isPresent()) {
            gear = optional.get();
        }
        gearRepository.save(gear);
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
