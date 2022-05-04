package edu.itstep.menu;

import edu.itstep.CarController;
import edu.itstep.DriverController;
import edu.itstep.entity.Car;
import edu.itstep.entity.Driver;
import edu.itstep.impl.CarControllerImpl;
import edu.itstep.impl.DriverControllerImpl;
import edu.itstep.repository.impl.CarRepositoryImpl;
import edu.itstep.repository.impl.DriverRepositoryImpl;
import edu.itstep.service.impl.CarServiceImpl;
import edu.itstep.service.impl.DriverServiceImpl;
import edu.itstep.view.impl.CarViewImpl;
import edu.itstep.view.impl.DriverViewImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Car> cars = new ArrayList<>();


    List<Driver> drivers = new ArrayList<>();
    CarController carController = new CarControllerImpl(
            new CarViewImpl(), new CarServiceImpl(new CarRepositoryImpl(cars), new DriverRepositoryImpl(drivers))
    );
    DriverController driverController = new DriverControllerImpl(
            new DriverViewImpl(), new DriverServiceImpl(new DriverRepositoryImpl(drivers))
    );

    public void init() throws IOException {
        cars.add(new Car("Audi", "80 B4", 1994, "standart", 8, 3000));
        cars.add(new Car("BMW", "X5", 2005, "premium", 12, 10000));
        cars.add(new Car("VW", "Polo", 2000, "standart", 6, 5000));
        cars.add(new Car("Reno", "Sandero Stepway", 2018, "premium", 7, 6000));
        cars.add(new Car("Lada", "Vesta", 1998, "economy", 5, 3000));

        drivers.add(new Driver("Ivanov", "Ivan", "Ivanovich", 45, "AA512456"));
        drivers.add(new Driver("Avanesyan", "Abrek", "Mizgekovich", 38, "E5566I"));
        drivers.add(new Driver("Smirnov", "Petr", "Alexeevich", 24, "ET69875"));
        drivers.add(new Driver("Prekrasnaya", "Markiza", "Petrovna", 37, "TH596485"));
        drivers.add(new Driver("Mamontov", "Prohor", "Semenovich", 65, "OP65464"));

        mainMenu();
        System.out.print("Choose an operation: ");

        while (true) {

            String pointOfMenu = br.readLine();

            switch (pointOfMenu) {

                case "1":
                    carMenu();
                    String carOperation = br.readLine();
                    while (true) {
                        if (carOperation.equals("13")) {
                            mainMenu();
                            break;
                        }
                        switch (carOperation) {
                            case "1":
                                carController.showAll();
                                System.out.println();
                                break;
                            case "2":
                                carController.findCarByEquipment();
                                System.out.println();
                                break;
                            case "3":
                                carController.findCarByYear();
                                System.out.println();
                                break;
                            case "4":
                                carController.findCarByDriver();
                                System.out.println();
                                break;
                            case "5":
                                carController.countTotalDepotCost();
                                System.out.println();
                                break;
                            case "6":
                                carController.getAllId();
                                System.out.println();
                                break;
                            case "7":
                                carController.findOneById();
                                System.out.println();
                                break;
                            case "8":
                                carController.addNewUnit();
                                System.out.println();
                                break;
                            case "9":
                                carController.attachDriverToCar();
                                break;
                            case "10":
                                carController.deleteById();
                                break;
                            case "11":
                                carController.sortByIssueYear();
                                System.out.println();
                                break;
                            case "12":
                                carController.sortByEquipment();
                                System.out.println();
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + carOperation);
                        }

                        System.out.print("Choose an operation of cars menu: ");
                        carOperation = br.readLine();
                    }
                    break;

                case "2":

                    driverMenu();
                    String driverOperation = br.readLine();
                   while(true) {
                       if (driverOperation.equals("8")) {
                           mainMenu();
                           break;
                       }
                       switch (driverOperation) {
                           case "1":
                               driverController.showAll();
                               System.out.println();
                               break;
                           case "2":
                               driverController.getAllId();
                               System.out.println();
                               break;
                           case "3":
                               driverController.findOneById();
                               System.out.println();
                               break;
                           case "4":
                               driverController.findByLastName();
                               System.out.println();
                               break;
                           case "5":
                               driverController.findByDriverLicence();
                               System.out.println();
                               break;
                           case "6":
                               driverController.addNewUnit();
                               System.out.println();
                               break;
                           case "7":
                               driverController.deleteById();
                               System.out.println();
                               break;
                           default:
                               throw new IllegalStateException("Unexpected value: " + driverOperation);
                       }

                       System.out.print("Choose an operation of drivers menu: ");
                       driverOperation = br.readLine();
                   }
                    break;

                case "3":
                    System.out.println("Application is stopped.");
                    System.exit(0);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + pointOfMenu);
            }
        }
    }

    private static void mainMenu() {
        System.out.println("1. Operations with cars.");
        System.out.println("2. Operations with drivers");
        System.out.println("3. Exit");
        System.out.println();
    }

    private static void carMenu() throws IOException {
        System.out.println("1. Show all cars.");
        System.out.println("2. Find car by equipment.");
        System.out.println("3. Find car by year of issue.");
        System.out.println("4. Find car by driver.");
        System.out.println("5. Show total cost of the depot.");
        System.out.println("6. Show unique IDs of all cars.");
        System.out.println("7. Find car by ID.");
        System.out.println("8. Add new car to the depot.");
        System.out.println("9. Attach driver to car.");
        System.out.println("10. Delete car from the depot.");
        System.out.println("11. Sort cars by issue year.");
        System.out.println("12. Sort cars by equipment.");
        System.out.println("13. Back to main menu.");
        System.out.println();
        System.out.print("Choose an operation: ");
    }

    private static void driverMenu() throws IOException {
        System.out.println("1. Show all drivers.");
        System.out.println("2. Show all drivers IDs.");
        System.out.println("3. Find driver by ID.");
        System.out.println("4. Find driver by last name.");
        System.out.println("5. Find driver by driver licence.");
        System.out.println("6. Hire driver.");
        System.out.println("7. Fire driver.");
        System.out.println("8. Back to main menu.");
        System.out.println();
        System.out.print("Choose an operation: ");
    }
}

