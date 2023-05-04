package com.solvd.laba.exceptions;

public class PrintNullException extends Exception {

    public PrintNullException() {
    }

    public PrintNullException(String message) {
        super(message);
    }

    public PrintNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrintNullException(Throwable cause) {
        super(cause);
    }

    public PrintNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
