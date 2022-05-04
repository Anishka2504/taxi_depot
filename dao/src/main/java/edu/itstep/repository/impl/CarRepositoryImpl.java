package edu.itstep.repository.impl;

import edu.itstep.entity.Car;
import edu.itstep.exception.EntityNotFoundException;
import edu.itstep.repository.CarRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CarRepositoryImpl implements CarRepository {

    List<Car> cars;

    public CarRepositoryImpl(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public Car findOneById(String id) {
        return cars.stream()
                .filter(car -> String.valueOf(car.getId()).equals(id))
                .findFirst().orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override
    public void addNewUnit(Car car) {
        cars.add(car);
    }

    @Override
    public void deleteById(String id) {
        cars.removeIf(car -> String.valueOf(car.getId()).equals(id));
    }

    @Override
    public List<UUID> getAllId() {
        return cars.stream().map(Car::getId).collect(Collectors.toList());
    }

    @Override
    public void sortByYear() {
        cars.sort(Comparator.comparing(Car::getIssueYear));
    }

    @Override
    public void sortByEquipment() {
        cars.sort(Comparator.comparing(Car::getEquipment));
    }
}
