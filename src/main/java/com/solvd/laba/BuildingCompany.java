package com.solvd.laba;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import com.solvd.laba.classes.*;
import com.solvd.laba.enums.DriveCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sound.midi.MetaEventListener;
import java.util.List;

public class BuildingCompany {

    private static final Logger LOGGER = LogManager.getLogger(BuildingCompany.class);

    public static void main(String[] args) {

        // ======================================================
        //add list to CLient class and method addClient
        //add hashset to Transactions, because it cannot dublicate.
        //add to bulldozer class list.
        //remake in the class Vehicles exception with Year
        //remake Crane.build wit exceptions
        //re-wright projects in ArchiveData and add arraylist
        //add custom LinkedList - partтrrsList<String>
        // ======================================================

//        LinkedList<String> partnersList = new LinkedList<String>();
//        partnersList.add("Bosch");
//        partnersList.add("Apple");
//        partnersList.add("Samsung");
//        partnersList.add("Mechanic Limited company");
//
//        Transaction allTransactions = new Transaction();
//        List<Bulldozer> allBuldozers = new ArrayList<>();
//
//        allBuldozers.add(new Bulldozer("MERCEDES", 2005, true, 4));
//        allBuldozers.add(new Bulldozer("MAZ", 2015, true, 5));
//        allBuldozers.add(new Bulldozer("KAMAZ", 2018, false, 6));
//        allBuldozers.add(new Bulldozer("UAZ", 2010, true, 7));
//
//        Crane crane = new Crane();
//        crane.build(0);
//
//        try {
//            Employee emp1 = new Employee("semen", 28);
//            emp1.printPersonalInfo(null);
//        } catch (PrintNullException | AgeException e) {
//            LOGGER.error(e.getMessage());
//        }

//
//        File file = new File(System.getProperty("user.dir") + "/src/main/resources/input.txt");
//        String str = "";
//        try (Scanner scanner = new Scanner(file)) {
//            while (scanner.hasNextLine()) {
//                str = scanner.nextLine();
//            }
//        } catch (FileNotFoundException e) {
//            LOGGER.error("File Not Found Exception caught!");
//        }

        // ======================================================
        //made FileReader task
        //add enums for different classes
        //add biFunction to class Project
        //add lambda to searching into arraylist
        //add method check to Crane using lambda Predicate
        //add method to Project with Consumer lambda
        //add Сustom lambda to class Driver to chose driver with category
        //add Function to class Driver in method get category
        //add custom method compare age employers in class Employee
        //add custom interface that convert levels to meters using constant height for Class Crane
        // ======================================================

//        Project project1 = new Project();
//        System.out.println(project1.calculateCost(5, 10));
//
//        ArrayList allPartners = new ArrayList<>(Collections.singleton(partnersList));
//        allPartners.forEach(partner -> System.out.println(partner));

//        Project projectWithLambda = new Project("Lambda explanation", ProjectType.LARGE_BUILDING,500,"Vasya");
//        Project.printProjectInfo(projectWithLambda);
//
//        Crane crane1 = new Crane("Zubr",2015,8,50);
//        crane1.convertToMeters();
//        System.out.println(crane1.check(10));

        List<Driver> allDrivers = new ArrayList<>();
        allDrivers.add(new Driver("Vasya", 25, 2000, DriveCategory.A));
        allDrivers.add(new Driver("Alex", 55, 5500, DriveCategory.B));
        allDrivers.add(new Driver("Rob", 35, 2500, DriveCategory.C));
        allDrivers.add(new Driver("Alex", 55, 5566, DriveCategory.B));
        allDrivers.add(new Driver("Tom", 55, 2500, DriveCategory.B));
        allDrivers.add(new Driver("Bob", 55, 50, DriveCategory.A));
        System.out.println(allDrivers.size());
        System.out.println(Driver.getDriverCategory(allDrivers, DriveCategory.B));
//
//        Employee emp1 = new Driver("Den",35,431,DriveCategory.B);
//        Employee emp2 = new Electric("John",45,540,2);
//        Employee.compareEmployersAge(emp1,emp2);

        // ======================================================
        // add method that show objects that have a salary greater than 2000, and sorted by them max. // use sorted
        // add method that create List of objects with categoryB. // use collect
        // add method that count the number of drivers with name Alex.
        // use logger.info instead of print ln, norm?
        // create method checkReflections for object
        // use reflection for create object, work with fields, methods

        Driver.streamDriver(allDrivers);
        checkReflections(new Employee());


    }

    public static void checkReflections(Object o) {
        Class ourClass = o.getClass();
        LOGGER.info("Print info about Class: " + ourClass + ".");
        System.out.println("===================================");
        LOGGER.info("Class name: " + ourClass);
        LOGGER.info("Fields: " + Arrays.toString(ourClass.getDeclaredFields()));
        LOGGER.info("Parent class: " + ourClass.getSuperclass());
        LOGGER.info("Methods : " + Arrays.toString(ourClass.getDeclaredMethods()));
        LOGGER.info("Constructors : " + Arrays.toString(ourClass.getConstructors()));
        System.out.println("=========Creating================");

        Constructor[] constructors = ourClass.getDeclaredConstructors();

        Object obj = null;

        try {
            obj = (Object) ourClass.getConstructor(String.class, int.class, int.class).newInstance("Object", 5, 2000);
            LOGGER.info(obj);
            System.out.println("=======Work with fields==========");
            Field salary = ourClass.getDeclaredField("salary");
            salary.setAccessible(true);
            salary.set(obj, 4000);
            LOGGER.info(obj);
            System.out.println("=====Work with methods =====");
            Method printPersonalInfo = ourClass.getDeclaredMethod("printPersonalInfo");
            printPersonalInfo.setAccessible(true);
            printPersonalInfo.invoke(obj);
        } catch (InstantiationException e) {
            LOGGER.error(e.getMessage());
        } catch (IllegalAccessException e) {
            LOGGER.error(e.getMessage());
        } catch (InvocationTargetException e) {
            LOGGER.error(e.getMessage());
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
        } catch (NoSuchFieldException e) {
            LOGGER.error(e.getMessage());
        }
    }
}



