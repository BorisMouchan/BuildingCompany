package com.solvd.laba;

import com.solvd.laba.classes.*;
import com.solvd.laba.exceptions.*;
import com.solvd.laba.enums.CurrencyType;
import com.solvd.laba.enums.DriveCategory;
import com.solvd.laba.enums.ProjectType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.solvd.laba.linkedList.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BuildingCompany {
    private static final Logger LOGGER = LogManager.getLogger(BuildingCompany.class);

    public static void main(String[] args) {
//
//        LinkedList<String> partnersList = new LinkedList<String>();
//        partnersList.add("Bosch");
//        partnersList.add("Apple");
//        partnersList.add("Samsung");
//        partnersList.add("Mechanic Limited company");
//        partnersList.printList();
//        System.out.println("===============");
//        partnersList.remove("Samsung");
//        partnersList.printList();

        Transaction allTransactions = new Transaction();
        Bulldozer allBuldozers = new Bulldozer();

        Bulldozer bull2 = new Bulldozer("AZ",-2005,true,4);
        Bulldozer bull3 = new Bulldozer("MAZ",-2005,true,5);

        Crane crane = new Crane();
        crane.build(0);


        try {Employee emp1 = new Employee("semen", 28);
            emp1.printPersonalInfo(null);
        } catch (PrintNullException | AgeException e) {
            LOGGER.error(e.getMessage());
        }

        try {
           Driver driv = new Driver("name",88,1800,DriveCategory.B);
        } catch (AgeException e) {
            LOGGER.error(e.getMessage());
        }

        Driver driv1 = new Driver();
        try {
            driv1.setPersonAge(90);
        } catch (AgeException e) {
            LOGGER.error(e.getMessage());
        }

        Transaction trns = new Transaction("213","Warsaw","aqa11","ALFA", CurrencyType.USD,"Pay",500);
        try {
            trns.makePayments();
        } catch (TransactionException e) {
            LOGGER.error(e.getMessage());
        }
//        allTransactions.addTransaction(trns);

        File file = new File(System.getProperty("user.dir") + "/src/main/resources/input.txt");
        String str = "";
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File Not Found Exception caught!");
        }


        //add list to CLient class and method addClient
        //add hashset to Transactions, because it cannot dublicate.
        //add to bulldozer class list.
        //remake in the class Vehicles exception with Year
        //remake Crane.build wit exceptions
        //rewright projects in ArchiveData and add arraylist
        //add custom LinkedList - partresList<String>

    }
}

