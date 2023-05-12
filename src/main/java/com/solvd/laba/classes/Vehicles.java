package com.solvd.laba.classes;

import com.solvd.laba.exceptions.NegativePurchaseYearException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Vehicles {

    private static final Logger LOGGER = LogManager.getLogger(Vehicles.class);

    protected String vehicleName;
    protected int purchaseYear;
    protected boolean warranty;

    public Vehicles() {
    }

    public Vehicles(String vehicleName, int purchaseYear, boolean warranty) {
        this.vehicleName = vehicleName;
        this.purchaseYear = purchaseYear;
        this.warranty = warranty;
    }

    public Vehicles(String vehicleName, int purchaseYear) {
        this.vehicleName = vehicleName;
        this.purchaseYear = purchaseYear;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public void setPurchaseYear(int purchaseYear) {
        if (purchaseYear < 0) {
            try {
                throw new NegativePurchaseYearException("Be careful! Purchase year is negative! ");
            } catch (NegativePurchaseYearException e) {
                LOGGER.error(e.getMessage());
            }
        }
        this.purchaseYear = purchaseYear;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    public abstract void moveToService();

    public final void changeTires() {
        int WEATHER_TO_CHANGE_TIRES = 4;
        if (Weather.getTodayWeather() < WEATHER_TO_CHANGE_TIRES) {
            System.out.println("Need to change tires! ");
        }
    }
}
