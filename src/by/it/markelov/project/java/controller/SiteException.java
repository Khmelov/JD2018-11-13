package by.it.markelov.project.java.controller;

public class SiteException extends Exception{
    public SiteException() {
    }

    public SiteException(String s) {
        super(s);
    }

    public SiteException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public SiteException(Throwable throwable) {
        super(throwable);
    }

    public SiteException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
