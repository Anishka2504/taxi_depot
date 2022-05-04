package edu.itstep.view.impl;

import edu.itstep.entity.Driver;
import edu.itstep.view.DriverView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class DriverViewImpl implements DriverView {

    @Override
    public String findOneById() throws IOException {
        System.out.print("Enter driver's id: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (br.readLine().length() != 36) {
            System.out.println("Wrong ID! Try again");
        }
        return br.readLine();
    }

    @Override
    public void showAllId() {
        System.out.println("List of all drivers identifications: ");
    }

    @Override
    public Driver add() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter driver's last name: ");
        String lastName = br.readLine();
        System.out.print("Enter driver's name: ");
        String name = br.readLine();
        System.out.print("Enter driver's middle name: ");
        String middleName = br.readLine();
        System.out.print("Enter driver's age: ");
        int age = Integer.parseInt(br.readLine());
        System.out.print("Enter number of driver licence: ");
        String licence = br.readLine();
        return new Driver(lastName, name, middleName, age, licence);
    }

    @Override
    public String deleteById() throws IOException {
        System.out.print("Enter id of the driver you want to fire: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (br.readLine().length() != 36) {
            System.out.println("Wrong ID! Try again");
        }
        return br.readLine();
    }

    @Override
    public String findByLastName() throws IOException {
        System.out.print("Enter last name to find a driver: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    @Override
    public String findByDriverLicence() throws IOException {
        System.out.print("Enter a number of driver licence to find a driver: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    @Override
    public void showAllDrivers(List<Driver> drivers) {
        if (drivers.size() == 0) {
            System.out.println("No drivers in the depot yet.");
        }
        drivers.forEach(System.out::println);
    }
}
