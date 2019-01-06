package by.it.skarpovich.calc;

public class CalcException extends Exception{

    public CalcException() {
        super("ERROR: blank CalcException");
    }

    public CalcException(String message) {
        super("ERROR: "+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
