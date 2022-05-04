package edu.itstep.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Car {

    private final UUID id;
    private String brand;
    private String model;
    private int issueYear;
    private String equipment;
    private int fuelConsumption;
    private List<Driver> drivers = new ArrayList<>();
    private int cost;

    public Car(String brand, String model, int issueYear, String equipment, int fuelConsumption, int cost) {
        this.id = UUID.randomUUID();
        this.brand = brand;
        this.model = model;
        this.issueYear = issueYear;
        this.equipment = equipment;
        this.fuelConsumption = fuelConsumption;
        this.cost = cost;
    }

    public void setDriver(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public String toString() {
        return getBrand() +" " + getModel() +
                ", year - " + issueYear +
                ", equipment - " + equipment +
                ", fuelConsumption - " + fuelConsumption + " l/100 km"
                + "\ndrivers: " + (drivers.isEmpty() ? "no drivers assigned" : drivers);
    }
}
