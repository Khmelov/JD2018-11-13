package by.it.karnilava.project05.java.controller;

public class SiteException extends Exception {
    public SiteException() {
    }


    public SiteException(String message) {
            super(message);
        }

    public SiteException(String message, Throwable cause) {
            super(message, cause);
        }

    public SiteException(Throwable cause) {
            super(cause);
        }
    }



