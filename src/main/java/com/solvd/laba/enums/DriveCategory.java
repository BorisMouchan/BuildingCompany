package com.solvd.laba.enums;

import com.solvd.laba.classes.Driver;

public enum DriveCategory {
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private final String driveCategory;

    public String getDriveCategory() {
        return driveCategory;
    }

    DriveCategory(String driveCategory) {
        this.driveCategory = driveCategory;
    }

}
