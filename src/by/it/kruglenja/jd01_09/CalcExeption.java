package by.it.kruglenja.jd01_09;

/**
 * Created by user on 11.12.2018.
 */
public class CalcExeption extends Exception{
    public CalcExeption() {
        super("ERROR: Blank CalcExeption");
    }

    public CalcExeption(String message) {
        super("ERROR: "+message);
    }

    public CalcExeption(String message, Throwable cause) {
        super("ERROR: " +message, cause);
    }

    public CalcExeption(Throwable cause) {
        super(cause);
    }
}
