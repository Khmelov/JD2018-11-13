package by.it.markelov.calc;

public class CalcExeption extends Exception {

    public CalcExeption() {
    }

    public CalcExeption(String message) {
        super("Error: "+message);
    }

    public CalcExeption(String message, Throwable why) {
        super("Error: "+message, why);
    }

    public CalcExeption(Throwable why) {
        super(why);
    }
}
