package edu.itstep.service.impl;

import edu.itstep.entity.Car;
import edu.itstep.entity.Driver;
import edu.itstep.repository.CarRepository;
import edu.itstep.repository.DriverRepository;
import edu.itstep.repository.impl.CarRepositoryImpl;
import edu.itstep.service.CarService;

import java.util.*;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private DriverRepository driverRepository;

    public CarServiceImpl(CarRepository carRepository, DriverRepository driverRepository) {
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public Car findCarById(String id) {
        return carRepository.findOneById(id);
    }

    @Override
    public List<Car> getAllCars() {

        return carRepository.getAll();
    }

    @Override
    public void sortCarsByYear() {
        carRepository.sortByYear();
    }

    @Override
    public void sortCarsByEquipment() {
        carRepository.sortByEquipment();
    }

    @Override
    public void addNewCar(Car car) {
        carRepository.addNewUnit(car);
    }

    @Override
    public void attachDriverToCar(String driverId, String carId) {
        findCarById(carId).setDriver(driverRepository.findOneById(driverId));
    }

    @Override
    public void deleteCarById(String id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> findCarByEquipment(String equipment) {
        return carRepository.getAll().stream().filter(car -> car.getEquipment().equalsIgnoreCase(equipment))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> findCarByYear(int year) {
        List<Car> result = carRepository.getAll().stream().filter(car -> car.getIssueYear() == year)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            System.out.println("No cars are found");
        }
        return result;
    }

    @Override
    public List<Car> findCarByDriver(String driverId) {
        List<Car> result = new ArrayList<>();
        for (Car car : carRepository.getAll()) {
            for (Driver driver : car.getDrivers()) {
                if (driverId.equalsIgnoreCase(String.valueOf(driver.getId()))) {
                    result.add(car);
                }
            }
        }
        return result;
    }

    @Override
    public int countCost() {
        int cost = 0;
        for (Car car : carRepository.getAll()) {
            cost += car.getCost();
        }
        return cost;
    }

    @Override
    public List<UUID> getAllCarsId() {
        return carRepository.getAllId();
    }

    @Override
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
