package ru.ibs.spring.springdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.spring.springdata.entity.Gear;

public interface GearRepository extends JpaRepository<Gear, Long> {


//    Gear findGearByEngineId(Long engineId);
//
//    List<Gear> findGearsByEngineId(Long engineId);

}
