package edu.itstep.service;

import edu.itstep.entity.Car;
import edu.itstep.repository.CarRepository;

import java.util.List;
import java.util.UUID;

public interface CarService {

    Car findCarById(String id);

    List<Car> getAllCars();

    void sortCarsByYear();

    void sortCarsByEquipment();

    void addNewCar(Car car);

    void attachDriverToCar(String driverId, String CarId);

    void deleteCarById(String id);

    List<Car> findCarByEquipment(String equipment);

    List<Car> findCarByYear(int year);

    List<Car> findCarByDriver(String driverId);

    int countCost();

    List<UUID> getAllCarsId();

    void setCarRepository(CarRepository carRepository);
}
