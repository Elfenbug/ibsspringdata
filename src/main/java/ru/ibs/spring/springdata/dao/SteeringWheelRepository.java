package ru.ibs.spring.springdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.spring.springdata.entity.SteeringWheel;

public interface SteeringWheelRepository extends JpaRepository<SteeringWheel, Long> {
}
