package by.it.kovalyova.jd02_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Logger {
    private static Logger logger;

    private Logger() {
    }

    static Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }

        return logger;
    }

    synchronized void log(String text) throws IOException {
        try (
                BufferedWriter out = new BufferedWriter(
                        new FileWriter("log.txt", true)
                )) {
            out.write(text + "\n");
            out.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
