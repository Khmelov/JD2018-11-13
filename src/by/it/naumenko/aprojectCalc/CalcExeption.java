package by.it.naumenko.aprojectCalc;


import by.it.naumenko.aprojectCalc.resourse.ResourceManager;
import by.it.naumenko.aprojectCalc.resourse.TextTranslate;

public class CalcExeption extends Exception {
    static ResourceManager resVar= ResourceManager.INSTANCE;

    public CalcExeption() {
    }

    public CalcExeption(String message) {
        super(resVar.get(TextTranslate.ERROR)+" "+message);
    }

    public CalcExeption(String message, Throwable cause) {
        super(resVar.get(TextTranslate.ERROR)+" "+message, cause);
    }

    public CalcExeption(Throwable cause) {
        super(cause);
    }
}
