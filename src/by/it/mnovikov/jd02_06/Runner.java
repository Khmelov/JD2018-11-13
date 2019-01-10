package by.it.mnovikov.jd02_06;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getInstance();
        logger.log("Проверка связи 1");
        Thread.sleep(1000);
        logger.log("Проверка связи 2");
        Thread.sleep(1000);
        logger.log("Проверка связи 3");
    }
}
