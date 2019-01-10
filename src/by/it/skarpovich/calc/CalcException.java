package by.it.skarpovich.calc;

import by.it.skarpovich.calc.res.Messages;

class CalcException extends Exception {
    private Logger logger = Logger.getInstance();
    private LoggerDirector reporter = LoggerDirector.getInstance();
    public CalcException() {
        super(ResMan.INSTANCE.get(Messages.STR_ERROR));
        logger.log(ResMan.INSTANCE.get(Messages.STR_ERROR));
        reporter.log(ResMan.INSTANCE.get(Messages.STR_ERROR));
    }

    public CalcException(String message) {
        super(ResMan.INSTANCE.get(Messages.STR_ERROR) + " " + message);
        logger.log(ResMan.INSTANCE.get(Messages.STR_ERROR) + " " + message);
        reporter.log(ResMan.INSTANCE.get(Messages.STR_ERROR) + " " + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResMan.INSTANCE.get(Messages.STR_ERROR) + " " + message, cause);
        logger.log(ResMan.INSTANCE.get(Messages.STR_ERROR) + " " + message + cause);
        reporter.log(ResMan.INSTANCE.get(Messages.STR_ERROR) + " " + message + cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
        logger.log(ResMan.INSTANCE.get(Messages.STR_ERROR) + " " + cause);
        reporter.log(ResMan.INSTANCE.get(Messages.STR_ERROR) + " " + cause);
    }
}
