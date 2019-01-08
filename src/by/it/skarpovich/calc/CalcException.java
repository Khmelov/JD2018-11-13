package by.it.skarpovich.calc;

import by.it.skarpovich.calc.res.Messages;

import static by.it.skarpovich.calc.res.Messages.STR_ERROR;


public class CalcException extends Exception {

    public CalcException() {
        super(ResMan.INSTANCE.get(Messages.STR_ERROR));
    }

    public CalcException(String message) {
        super(ResMan.INSTANCE.get(Messages.STR_ERROR) + " " + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResMan.INSTANCE.get(Messages.STR_ERROR) + " " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
