package edu.itstep.repository.impl;

import edu.itstep.entity.Driver;
import edu.itstep.exception.EntityNotFoundException;
import edu.itstep.repository.DriverRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DriverRepositoryImpl implements DriverRepository {

    List<Driver> drivers;

    public DriverRepositoryImpl(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public Driver findOneById(String id) {
        return drivers.stream()
                .filter(driver -> String.valueOf(driver.getId()).equals(id))
                .findFirst().orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Driver> getAll() {
        return drivers;
    }

    @Override
    public void addNewUnit(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public void deleteById(String id) {
        drivers.removeIf(driver -> String.valueOf(driver.getId()).equals(id));
    }

    @Override
    public List<UUID> getAllId() {
        return drivers.stream().map(Driver::getId).collect(Collectors.toList());
    }
}
