package ru.ibs.spring.springdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.spring.springdata.entity.Engine;

public interface EngineRepository extends JpaRepository<Engine, Long> {
}
