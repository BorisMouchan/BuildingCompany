package com.solvd.laba.classes;

import com.solvd.laba.interfaces.IMoveable;
import com.solvd.laba.enums.DriveCategory;


import com.solvd.laba.interfaces.functional.ICalculate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Driver extends Employee implements IMoveable {

    private static final Logger LOGGER = LogManager.getLogger(Driver.class);
//    public static int count=0;

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


    public static List<Driver> getDriverCategory(List<Driver> allDrivers,DriveCategory driveCategory1) {
        int count=0;
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
            if(finalCount >0) {
                result="There are " + finalCount + " with this driver category";
            }
            return result;
        };
        System.out.println(func.apply(finalCount));

        return searchDrivers;

    }
}
