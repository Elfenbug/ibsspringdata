package ru.ibs.spring.springdata.service;

import ru.ibs.spring.springdata.entity.Manual;

import java.util.List;

public interface ManualService {
    List<Manual> getAllManuals();

    void saveManual(Manual manual);

    Manual getManual(Long id);

    void deleteManual(Long id);

    void updateManual(Manual manual, Long id);
}
