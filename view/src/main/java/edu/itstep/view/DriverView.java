package edu.itstep.view;

import edu.itstep.entity.Driver;

import java.io.IOException;
import java.util.List;

public interface DriverView extends CrudOperationView<Driver>{

    String findByLastName() throws IOException;

    String findByDriverLicence() throws IOException;

    void showAllDrivers(List<Driver> drivers);
}
