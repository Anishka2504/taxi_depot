package edu.itstep.repository;

import edu.itstep.CrudRepository;
import edu.itstep.entity.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car> {

    void sortByYear();

    void sortByEquipment();

}
