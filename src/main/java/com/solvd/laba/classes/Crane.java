package com.solvd.laba.classes;

import com.solvd.laba.exceptions.IncorectLevelBuildingException;
import com.solvd.laba.exceptions.NegativePurchaseYearException;
import com.solvd.laba.interfaces.IBulding;
import com.solvd.laba.interfaces.IDestroy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Crane extends Vehicles implements IDestroy, IBulding {

    private static final Logger LOGGER = LogManager.getLogger(Crane.class);

    private int maxHeight;
    private int maxWeightToUp;
    protected int weightToUp;

    public Crane() {
    }

    public Crane(String vehicleName, int purchaseYear, boolean warranty, int maxHeight, int maxWeightToUp) {
        super(vehicleName, purchaseYear, warranty);
        this.maxHeight = maxHeight;
        this.maxWeightToUp = maxWeightToUp;
    }
    public Crane(String vehicleName, int purchaseYear, int maxHeight, int maxWeightToUp) {
        super(vehicleName, purchaseYear);
        this.maxHeight = maxHeight;
        this.maxWeightToUp = maxWeightToUp;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxWeightToUp() {
        return maxWeightToUp;
    }

    public void setMaxWeightToUp(int maxWeightToUp) {
        this.maxWeightToUp = maxWeightToUp;
    }

    @Override
    public String toString() {
        return "Crane{" +
                "maxHeight=" + maxHeight +
                ", maxWeightToUp=" + maxWeightToUp +
                ", weightToUp=" + weightToUp +
                ", vehicleName='" + vehicleName + '\'' +
                ", purchaseYear=" + purchaseYear +
                ", warranty=" + warranty +
                "} " + super.toString();
    }

    @Override
    public void moveToService() {
        if (purchaseYear < LocalDate.now().getYear()) {
            System.out.println("To service!");
        } else {
            System.out.println("Warranty is over!");
        }
    }

    @Override
    public void detroy() {
        System.out.println(getVehicleName() + " cannot destroy it! ");
    }

    @Override
    public void build(int level) {
        if (level <= 0) {
            try {
                throw new IncorectLevelBuildingException("Please, wright correct level ");
            } catch (IncorectLevelBuildingException e) {
                LOGGER.error(e.getMessage());
            }
        }
        if (weightToUp < maxWeightToUp) {
            System.out.println("Building...");
        }
    }

    public boolean check(int level){
        Predicate<Integer> buildingHeight = i -> maxHeight <=i;
        return !buildingHeight.test(level);
    }




}


