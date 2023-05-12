package com.solvd.laba;

import java.util.*;
import java.util.function.Predicate;

import com.solvd.laba.classes.Bulldozer;
import com.solvd.laba.classes.Crane;
import com.solvd.laba.classes.Driver;
import com.solvd.laba.classes.Project;
import com.solvd.laba.enums.DriveCategory;
import com.solvd.laba.enums.ProjectType;
import com.solvd.laba.interfaces.functional.ICalculate;
import com.solvd.laba.linkedList.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BuildingCompany {

    private static final Logger LOGGER = LogManager.getLogger(BuildingCompany.class);

    public static void main(String[] args) {

//        LinkedList<String> partnersList = new LinkedList<String>();
//        partnersList.add("Bosch");
//        partnersList.add("Apple");
//        partnersList.add("Samsung");
//        partnersList.add("Mechanic Limited company");
//
//        Transaction allTransactions = new Transaction();
//        Bulldozer allBuldozers = new Bulldozer();
//
//        Bulldozer bull2 = new Bulldozer("AZ", -2005, true, 4);
//        Bulldozer bull3 = new Bulldozer("MAZ", -2005, true, 5);
//
//        allBuldozers.addBulldozer(bull2);
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

//        Transaction trns = new Transaction("213", "Warsaw", "aqa11", "ALFA", CurrencyType.USD, "Pay", -500);
//        try {
//            trns.makePayments();
//        } catch (TransactionException e) {
//            LOGGER.error(e.getMessage());
//        }
//        allTransactions.addTransaction(trns);
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


        //add list to CLient class and method addClient
        //add hashset to Transactions, because it cannot dublicate.
        //add to bulldozer class list.
        //remake in the class Vehicles exception with Year
        //remake Crane.build wit exceptions
        //rewright projects in ArchiveData and add arraylist
        //add custom LinkedList - partтrrsList<String>
        // ========================================================================================================

        //add enums for diffrenet classes
        // biFunction to class Project
        //add lambda to searching into arraylist
        // add method check to Crane using lambda Predicate
        //add method to Project with Consumer lambda
        // add Сustom lambda to class Driver to chose driver with category
        //add Function to class Driver in method get category


//        Project project1 = new Project();
//        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a * b;
//        System.out.println(project1.calculateCost(5, 3, biFunction));
//
//        ArrayList allPartners = new ArrayList<>(Collections.singleton(partnersList));
//        allPartners.forEach(partner -> System.out.println(partner));

//        Project projectWithLambda = new Project("Lambda explanation", ProjectType.LARGE_BUILDING,500,"Vasya");
//        Project.printProjectInfo(projectWithLambda);

//        Crane crane1 = new Crane("Zubr",2015,8,50);
//        System.out.println(crane1.check(10));

        List<Driver> allDrivers = new ArrayList<>();
        allDrivers.add(new Driver("Vasya", 25, 2000, DriveCategory.A));
        allDrivers.add(new Driver("Alex", 55, 5500, DriveCategory.B));
        allDrivers.add(new Driver("Rob", 35, 2500, DriveCategory.C));
        allDrivers.add(new Driver("Alex", 55, 5566, DriveCategory.B));
        allDrivers.add(new Driver("Tom", 55, 2500, DriveCategory.B));
        allDrivers.add(new Driver("Bob", 55, 50, DriveCategory.A));
        System.out.println(allDrivers.size());

        System.out.println(Driver.getDriverCategoryB(allDrivers));



    }
}


