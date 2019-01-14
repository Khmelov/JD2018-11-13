package by.it.lobkova.calc;

public class ExceptionCalc extends Exception {

    public ExceptionCalc() {
        super();
    }

    public ExceptionCalc(String message) {
        super("ERROR: " + message);
    }

    public ExceptionCalc(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public ExceptionCalc(Throwable cause) {
        super(cause);
    }

    protected ExceptionCalc(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: " + message, cause, enableSuppression, writableStackTrace);
    }
}
