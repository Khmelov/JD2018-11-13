package by.it.medvedeva.jd02_06;


import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            Logger logger = Logger.getInstance();
            logger.log("One");
            logger = Logger.getInstance();
            logger.log("2");
            logger = Logger.getInstance();
            logger.log("3");
            logger = Logger.getInstance();
            logger.log("4");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
