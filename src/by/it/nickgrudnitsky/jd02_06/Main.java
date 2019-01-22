package by.it.nickgrudnitsky.jd02_06;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Error 1");
        logger = Logger.getInstance();
        logger.log("Error 2");
        logger = Logger.getInstance();
        logger.log("Error 3");

    }
}
