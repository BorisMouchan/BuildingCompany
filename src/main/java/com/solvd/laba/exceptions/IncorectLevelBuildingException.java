package com.solvd.laba.exceptions;

public class IncorectLevelBuildingException extends Exception {

    public IncorectLevelBuildingException() {
    }

    public IncorectLevelBuildingException(String message) {
        super(message);
    }

    public IncorectLevelBuildingException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorectLevelBuildingException(Throwable cause) {
        super(cause);
    }

    public IncorectLevelBuildingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
