package by.it.karnilava.calc;

public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {

        super(SwitchLanguages.rb.getString("ERROR")+" "+message);
       // LoggerErrors.writeReport(SwitchLanguages.rb.getString("ERROR")+" "+message);
    }

    public CalcException(String message, Throwable cause) {
        super(SwitchLanguages.rb.getString("ERROR")+" "+message, cause);
       // LoggerErrors.writeReport(SwitchLanguages.rb.getString("ERROR")+" "+message+cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(SwitchLanguages.rb.getString("ERROR")+" "+message, cause, enableSuppression, writableStackTrace);
       // LoggerErrors.writeReport(SwitchLanguages.rb.getString("ERROR")+" "+message+cause+enableSuppression+writableStackTrace);
    }
}
