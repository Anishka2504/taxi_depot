package edu.itstep.service;

import edu.itstep.entity.Driver;

import java.util.List;
import java.util.UUID;

public interface DriverService {

    Driver findOneById(String id);

    List<UUID> getAllDriversId();

    List<Driver> getAll();

    void addNewUnit(Driver driver);

    void deleteById(String id);

    List<Driver> findByLastName(String lastName);

    Driver findByDriverLicence(String driverLicence);
}
