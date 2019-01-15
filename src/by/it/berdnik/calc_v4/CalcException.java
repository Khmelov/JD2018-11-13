package by.it.berdnik.calc_v4;

public class CalcException extends Exception{

    private Logger logger = Logger.getInstance();

    public CalcException() {
        super("ERROR: blank CalcException");
        logger.log(("ERROR: blank CalcException"));
    }

    public CalcException(String message) {
        super("ERROR: "+message);
        logger.log(("ERROR: "+message));
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
        logger.log(("ERROR: "+message + cause));
    }

    public CalcException(Throwable cause) {
        super(cause);
        logger.log(("ERROR: " + cause));
    }
}
