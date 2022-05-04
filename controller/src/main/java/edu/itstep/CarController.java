package edu.itstep;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface CarController extends CrudController{

    void sortByEquipment();

    void sortByIssueYear();

    void findCarByEquipment() throws IOException;

    void findCarByYear() throws IOException;

    void findCarByDriver() throws IOException;

    void countTotalDepotCost();

    void attachDriverToCar() throws IOException;
}
