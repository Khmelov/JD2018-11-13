package by.it.seroglazov.project.java.controller;

public class SiteException extends Exception{

    SiteException() {
    }

    public SiteException(String message) {
        super(message);
    }

    SiteException(String message, Throwable cause) {
        super(message, cause);
    }

    SiteException(Throwable cause) {
        super(cause);
    }
}
