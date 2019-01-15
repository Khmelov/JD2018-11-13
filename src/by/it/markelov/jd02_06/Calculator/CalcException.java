package by.it.markelov.jd02_06.Calculator;

public class CalcException extends Exception {

    public CalcException() {
        MyLogger.getInstance().printToFile("Error");
    }

    public CalcException(String message) {
        super("Error: " + message);
        MyLogger.getInstance().printToFile(message);
    }

    public CalcException(String message, Throwable why) {
        super("Error: " + message, why);
        MyLogger.getInstance().printToFile(message);
    }

    public CalcException(Throwable why) {
        super(why);
        MyLogger.getInstance().printToFile("Error");
    }
}
