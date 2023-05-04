package com.solvd.laba.classes;

public abstract class Weather {
    private static int todayWeather; // get weather from the external web services for example...

    public static int getTodayWeather() {
        return todayWeather;
    }

}
