package com.solvd.laba.classes;

import com.solvd.laba.exceptions.NegativePurchaseYearException;
import com.solvd.laba.interfaces.IBulding;
import com.solvd.laba.interfaces.IDestroy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Bulldozer extends Vehicles implements IBulding, IDestroy {

    List<Bulldozer> allBulldozers = new ArrayList<>();

    private final int MAX_SPEED = 80;
    private int maxWeight;
    private static int amountOfGasoline;

    public Bulldozer() {
    }

    public Bulldozer(String vehicleName, int purchaseYear, boolean warranty, int maxWeight) {
        super(vehicleName, purchaseYear, warranty);
        this.maxWeight = maxWeight;

    }

//    static {
//        System.out.println("How many gasoline do you need? ");
//        Scanner scanner = new Scanner(System.in);
//        amountOfGasoline = scanner.nextInt();
//    }

    public int getMAX_SPEED() {
        return MAX_SPEED;
    }


    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bulldozer bulldozer = (Bulldozer) o;
        return purchaseYear == bulldozer.purchaseYear && warranty == bulldozer.warranty && MAX_SPEED == bulldozer.MAX_SPEED && maxWeight == bulldozer.maxWeight && Objects.equals(vehicleName, bulldozer.vehicleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleName, purchaseYear, warranty, MAX_SPEED, maxWeight);
    }

    @Override
    public void moveToService() {
//        if (purchaseYear < LocalDate.EPOCH.getYear()) {
//            System.out.println("To service!");
//        } else {
//            System.out.println("Warranty is over!");
//        }
    }

    @Override
    public void detroy() {
        System.out.println("Destroy!");
    }


    @Override
    public void build(int level) {
        System.out.println("Building");
    }


    public List<Bulldozer> addBulldozer(Bulldozer bulldozer) {
        allBulldozers.add(bulldozer);
        return allBulldozers;
    }

}

