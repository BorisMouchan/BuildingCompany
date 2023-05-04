package com.solvd.laba.enums;

public enum AdvertisingType {
    GOOGLE("GOOGLE"),
    FACEBOOK("FACEBOOK"),
    INSTAGRAM("INSTAGRAM");

    private final String advertisingType;

    AdvertisingType(String advertisingType) {
        this.advertisingType = advertisingType;
    }

    public String getAdvertisingType() {
        return advertisingType;
    }

}
