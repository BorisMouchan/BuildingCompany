package com.solvd.laba.exceptions;

public class NegativePurchaseYearException extends Exception {
    public NegativePurchaseYearException() {
    }

    public NegativePurchaseYearException(String message) {
        super(message);
    }

    public NegativePurchaseYearException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativePurchaseYearException(Throwable cause) {
        super(cause);
    }

    public NegativePurchaseYearException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
