package by.it.zhivov.project.java.controller;

public class SiteExeption extends Exception {
    public SiteExeption() {
    }

    public SiteExeption(String message) {
        super(message);
    }

    public SiteExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public SiteExeption(Throwable cause) {
        super(cause);
    }
}
