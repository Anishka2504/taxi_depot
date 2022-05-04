package edu.itstep.impl;

import edu.itstep.DriverController;
import edu.itstep.service.DriverService;
import edu.itstep.view.DriverView;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class DriverControllerImpl implements DriverController {

    private DriverView driverView;
    private DriverService driverService;

    public DriverControllerImpl(DriverView driverView, DriverService driverService) {
        this.driverView = driverView;
        this.driverService = driverService;
    }

    @Override
    public void findOneById() throws IOException {
        System.out.println(driverService.findOneById(driverView.findOneById()));
    }

    @Override
    public void showAll() {
        driverView.showAllDrivers(driverService.getAll());
    }

    @Override
    public void addNewUnit() throws IOException {
        driverService.addNewUnit(driverView.add());
        System.out.println("The driver is hired");
    }

    @Override
    public void deleteById() throws IOException {
        driverService.deleteById(driverView.deleteById());
        System.out.println("Driver is fired");
    }

    @Override
    public void getAllId() {
        List<UUID> allId = driverService.getAllDriversId();
        for (UUID uuid : allId) {
            System.out.println(uuid + " - "
                    + driverService.findOneById(String.valueOf(uuid)).getLastName() + " "
                    + driverService.findOneById(String.valueOf(uuid)).getName() + " "
                    + driverService.findOneById(String.valueOf(uuid)).getMiddleName());
        }
    }

    @Override
    public void findByLastName() throws IOException {
        System.out.println(driverService.findByLastName(driverView.findByLastName()));
    }

    @Override
    public void findByDriverLicence() throws IOException {
        System.out.println(driverService.findByDriverLicence(driverView.findByDriverLicence()));
    }

}
