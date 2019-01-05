package by.it.markelov.jd02_04;

public class CalcException extends Exception {

    public CalcException() {
    }

    public CalcException(String message) {
        super("Error: "+message);
    }

    public CalcException(String message, Throwable why) {
        super("Error: "+message, why);
    }

    public CalcException(Throwable why) {
        super(why);
    }
}
