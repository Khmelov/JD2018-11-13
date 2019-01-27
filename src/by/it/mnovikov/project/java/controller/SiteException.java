package by.it.mnovikov.project.java.controller;

public class SiteException extends Exception {

    public SiteException() {
    }

    public SiteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SiteException(Throwable cause) {
        super(cause);
    }

    public SiteException(String message) {

        super(message);
    }
}
