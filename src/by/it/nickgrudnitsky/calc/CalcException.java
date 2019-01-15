package by.it.nickgrudnitsky.calc;

public class CalcException extends Exception {
    private static ResManager resManager = ResManager.INSTANCE;
    public CalcException() {
    }

    public CalcException(String message) {
        super(resManager.get(Errors.ERROR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(resManager.get(Errors.ERROR) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(resManager.get(Errors.ERROR) + message, cause, enableSuppression, writableStackTrace);
    }
}
