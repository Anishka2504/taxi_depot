package edu.itstep.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class Driver implements Comparable<Driver> {

    private final UUID id;
    private String lastName;
    private String name;
    private String middleName;
    private int age;
    private String driverLicence;

    public Driver(String lastName, String name, String middleName, int age, String driverLicence) {
        this.id = UUID.randomUUID();
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.age = age;
        this.driverLicence = driverLicence;
    }

    @Override
    public String toString() {
        return getLastName() + " "
                + getName() + " "
                + getMiddleName()
                + ", " + age + " y.o."
                + ", driver licence № " + driverLicence;
    }

    @Override
    public int compareTo(Driver driver) {
        return age - driver.getAge();
    }
}
