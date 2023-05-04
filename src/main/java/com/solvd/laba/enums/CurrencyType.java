package com.solvd.laba.enums;

public enum CurrencyType {
    USD("USD"),
    EUR("EUR"),
    CNY("CNY");

    private final String currencyType;

    public String getCurrencyType() {
        return currencyType;
    }

    CurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }
}
