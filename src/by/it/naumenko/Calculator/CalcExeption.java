package by.it.naumenko.Calculator;

public class CalcExeption extends Exception {

    public CalcExeption() {
    }

    public CalcExeption(String message) {
        super("ERROR: "+message);
    }

    public CalcExeption(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalcExeption(Throwable cause) {
        super(cause);
    }
}
