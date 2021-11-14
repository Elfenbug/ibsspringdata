package ru.ibs.spring.springdata.service;

import ru.ibs.spring.springdata.entity.Gear;

import java.util.List;

public interface GearService {
    List<Gear> getAllGears();

    void saveGear(Gear gear);

    Gear getGear(Long id);

    void deleteGear(Long id);

    void updateGear(Gear gear, Long id);

//    Gear findGear(Car car);
//    List<Gear> findGears(Car car);
}
