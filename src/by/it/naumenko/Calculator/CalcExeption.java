package by.it.naumenko.Calculator;

import by.it.naumenko.Calculator.resourse.ResourceManager;
import by.it.naumenko.Calculator.resourse.TextTranslate;

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
