package com.solvd.laba.classes;

import com.solvd.laba.interfaces.IMoveable;
import com.solvd.laba.enums.DriveCategory;


import com.solvd.laba.interfaces.functional.ICalculate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Driver extends Employee implements IMoveable {

    private static final Logger LOGGER = LogManager.getLogger(Driver.class);

    private DriveCategory driveCategory;

    public Driver(String personName, int personAge, int salary, DriveCategory driveCategory) {
        super(personName, personAge, salary);
        this.driveCategory = driveCategory;
    }

    public Driver() {
    }

    public DriveCategory getDriveCategory() {
        return driveCategory;
    }

    public Driver setDriveCategory(DriveCategory driveCategory) {
        this.driveCategory = driveCategory;
        return null;
    }

    @Override
    public void driveTo() {
        System.out.println("Driver " + getPersonName() + " with " + driveCategory + " go to object! ");
    }

    @Override
    public void goToBoss() {
        System.out.println("Driver " + getPersonName() + " with " + driveCategory + " go to boss! ");
    }

    public static List<Driver> getDriverCategory(List<Driver> allDrivers, DriveCategory driveCategory1) {
        int count = 0;
        ICalculate<Driver> c = i -> i.getDriveCategory().equals(driveCategory1);
        List<Driver> searchDrivers = new ArrayList<>();
        for (Driver driver : allDrivers) {
            if (c.calculate(driver)) {
                searchDrivers.add(driver);
                count++;
            }
        }
        int finalCount = count;
        Function<Integer, String> func = f -> {
            String result = "No drivers with this category";
            if (finalCount > 0) {
                result = "There are " + finalCount + " with this driver category";
            }
            return result;
        };
        System.out.println(func.apply(finalCount));

        return searchDrivers;

    }

    public static void streamDriver(List<Driver> allDrivers) {
        // Show objects that have a salary greater than 2000, and sorted by them max.
        allDrivers.stream()
                .filter(driver -> driver.getSalary() >= 2000)
                .sorted(Comparator.comparing(Driver::getSalary))
                .forEach(LOGGER::info);
        System.out.println("====================");

        // Create List of objects with categoryB.
        List<Driver> driversWithCategoryB = allDrivers.stream()
                .filter(driver -> driver.getDriveCategory().equals(DriveCategory.B))
                .collect(Collectors.toList());
        for (Driver driver : driversWithCategoryB) {
            LOGGER.info(driver);
        }
        System.out.println("====================");

        // Count the number of drivers with name Alex.
        long count = allDrivers.stream().filter(driver -> driver.getPersonName().equals("Alex"))
                .count();
        LOGGER.info("The number of drivers with name Alex: " + count);
    }
}
