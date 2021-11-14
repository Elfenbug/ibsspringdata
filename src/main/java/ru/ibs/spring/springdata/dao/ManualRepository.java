package ru.ibs.spring.springdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.spring.springdata.entity.Manual;

public interface ManualRepository extends JpaRepository<Manual, Long> {
}
