package edu.itstep;

import java.io.IOException;

public interface DriverController extends CrudController{

    void findByLastName() throws IOException;

    void findByDriverLicence() throws IOException;
}
