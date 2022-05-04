package edu.itstep.service.impl;

import edu.itstep.entity.Car;
import edu.itstep.entity.Driver;
import edu.itstep.exception.EntityNotFoundException;
import edu.itstep.repository.CarRepository;
import edu.itstep.repository.DriverRepository;
import edu.itstep.service.DriverService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver findOneById(String id) {
        return driverRepository.findOneById(id);
    }

    @Override
    public List<UUID> getAllDriversId() {
        return driverRepository.getAllId();
    }

    @Override
    public List<Driver> getAll() {
        return driverRepository.getAll();
    }

    @Override
    public void addNewUnit(Driver driver) {
        driverRepository.addNewUnit(driver);
    }

    @Override
    public void deleteById(String id) {
        driverRepository.deleteById(id);
    }

    @Override
    public List<Driver> findByLastName(String lastName) {
        List<Driver> result = driverRepository.getAll().stream().filter(driver -> driver.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            System.out.println("No driver found");
        }
        return result;
    }

    @Override
    public Driver findByDriverLicence(String driverLicence) {
        Driver result = driverRepository.getAll().stream().filter(driver -> driver.getDriverLicence()
                .equalsIgnoreCase(driverLicence)).findFirst().orElseThrow(EntityNotFoundException::new);
        return result;
    }

}


