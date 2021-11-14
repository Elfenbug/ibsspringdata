package ru.ibs.spring.springdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.spring.springdata.entity.Car;


public interface CarRepository extends JpaRepository<Car, Long> {
}
