package by.it.seroglazov.calc;

public class CalcException extends Exception{

    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(message);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    protected CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
