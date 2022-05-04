package edu.itstep.view;

import edu.itstep.entity.Car;

import java.io.IOException;
import java.util.List;

public interface CarView extends CrudOperationView<Car> {


    String findCarByEquipment() throws IOException;

    int findCarByYear() throws IOException;

    String findCarByDriver() throws IOException;

    void costOfDepot();

    void sortCarsByYear();

    void sortCarsByEquipment();

    void showAllCars(List<Car> cars);

    String[] attachDriverToCar() throws IOException;
}
