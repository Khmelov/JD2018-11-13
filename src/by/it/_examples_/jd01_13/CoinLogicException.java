package by.it._examples_.jd01_13;

public class CoinLogicException  extends Exception {
    //нужно 4 конструктора для своего исключения
    public CoinLogicException() {
    }
    public CoinLogicException(String message, Throwable exception) {
        super(message, exception);
    }
    public CoinLogicException(String message) {
        super(message);
    }
    public CoinLogicException (Throwable exception) {
        super(exception);
    }
}
