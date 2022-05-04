package edu.itstep.impl;

import edu.itstep.CarController;
import edu.itstep.entity.Car;
import edu.itstep.service.CarService;
import edu.itstep.view.CarView;
import lombok.Setter;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Setter
public class CarControllerImpl implements CarController {

    private CarView carView;
    private CarService carService;

    public CarControllerImpl(CarView carView, CarService carService) {
        this.carView = carView;
        this.carService = carService;
    }



    @Override
    public void sortByEquipment() {
        carService.sortCarsByEquipment();
        carView.sortCarsByEquipment();
    }

    @Override
    public void sortByIssueYear() {
        carService.sortCarsByYear();
        carView.sortCarsByYear();
    }

    @Override
    public void findCarByEquipment() throws IOException {
        List<Car> cars = carService.findCarByEquipment(carView.findCarByEquipment());
        cars.forEach(System.out::println);
    }

    @Override
    public void findCarByYear() throws IOException {
        List<Car> cars = carService.findCarByYear(carView.findCarByYear());
        cars.forEach(System.out::println);
    }

    @Override
    public void findCarByDriver() throws IOException {
        List<Car> cars = carService.findCarByDriver(carView.findCarByDriver());
        cars.forEach(System.out::println);
    }

    @Override
    public void countTotalDepotCost() {
        carView.costOfDepot();
        System.out.println(carService.countCost());
    }

    @Override
    public void findOneById() throws IOException {
        Car car = carService.findCarById(carView.findOneById());
        System.out.println(car);
    }

    @Override
    public void showAll() {
        carView.showAllCars(carService.getAllCars());
    }

    @Override
    public void addNewUnit() throws IOException {
        Car car = carView.add();
        carService.addNewCar(car);
        System.out.println("New car is added");
    }

    @Override
    public void getAllId() throws IOException {
        List<UUID> allId = carService.getAllCarsId();
        for (UUID uuid : allId) {
            System.out.println(uuid + " - " + carService.findCarById(String.valueOf(uuid)).getBrand()
                    + " " + carService.findCarById(String.valueOf(uuid)).getModel()
                    + " " + carService.findCarById(String.valueOf(uuid)).getIssueYear()
            );
        }

    }

    @Override
    public void attachDriverToCar() throws IOException {
        String[] idArray = carView.attachDriverToCar();
        carService.attachDriverToCar(idArray[0], idArray[1]);
    }

    @Override
    public void deleteById() throws IOException {
        carService.deleteCarById(carView.deleteById());
        System.out.println("Car is deleted");
    }
}
