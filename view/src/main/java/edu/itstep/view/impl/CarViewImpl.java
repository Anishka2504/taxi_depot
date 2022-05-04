package edu.itstep.view.impl;

import edu.itstep.entity.Car;
import edu.itstep.view.CarView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CarViewImpl implements CarView{

    @Override
    public String findCarByEquipment() throws IOException {
        System.out.println("Enter a type of equipment: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    @Override
    public int findCarByYear() throws IOException {
        System.out.print("Enter an issue year: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    @Override
    public String findCarByDriver() throws IOException {
        System.out.print("Enter driver's id: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    @Override
    public void costOfDepot() {
        System.out.print("Total cost of the depot is " );
    }

    @Override
    public void sortCarsByYear() {
        System.out.println("Cars are sorted by issue year.");
    }

    @Override
    public void sortCarsByEquipment() {
        System.out.println("Cars are sorted by equipment.");
    }

    @Override
    public void showAllCars(List<Car> cars) {
        if (cars.size() == 0) {
            System.out.println("No cars in the depot yet");
        }
            cars.forEach(System.out::println);


    }

    @Override
    public String findOneById() throws IOException {
        System.out.print("Enter car id: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carId = br.readLine();
        if (carId.length() != 36) {
            System.out.println("Wrong ID! Try again");
        }
        return carId;
    }

    @Override
    public void showAllId() {
        System.out.println("List of all car identifications:" );
    }

    @Override
    public Car add() throws IOException {
        System.out.print("Enter brand: ");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String brand = br1.readLine();
        System.out.print("Enter model: ");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String model = br2.readLine();
        System.out.print("Enter year of issue: ");
        BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br3.readLine());
        System.out.print("Enter equipment: ");
        BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
        String equipment = br4.readLine();
        System.out.print("Enter fuel consumption: ");
        BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));
        int consumption = Integer.parseInt(br5.readLine());
        System.out.print("Enter cost: ");
        BufferedReader br6 = new BufferedReader(new InputStreamReader(System.in));
        int cost = Integer.parseInt(br6.readLine());
        return new Car(brand, model, year, equipment, consumption, cost);
    }

    @Override
    public String deleteById() throws IOException {
        System.out.print("Enter id of car you want to delete: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carId = br.readLine();
        if (carId.length() != 36) {
            System.out.println("Wrong ID! Try again");
        }
        return carId;
    }

    @Override
    public String[] attachDriverToCar() throws IOException {
        System.out.print("Enter ID of the driver: ");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String driverId = br1.readLine();
        System.out.print("Enter ID of the car you want to attach driver to: ");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String carId = br2.readLine();
        System.out.println("Driver is attached to the car");
        return new String[]{driverId, carId};
    }
}
