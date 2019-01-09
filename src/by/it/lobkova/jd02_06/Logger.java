package by.it.lobkova.jd02_06;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Logger {

    private static Logger logger;

    private Logger() {
    }

    Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    //синхронизация по объекту по this - logger
    synchronized void log(String text) {
        try (BufferedWriter out = new BufferedWriter(
                    new FileWriter("text.txt", true))) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
