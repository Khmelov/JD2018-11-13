package by.it.baidak.calc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class Logger {

    private static Logger logger;
    private static String filename = Util.getPath("log.txt");

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

    synchronized void log(CalcException ex) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename,true))) {
            System.err.println(ex.getMessage());
            Logger lo = Logger.getInstance();
            out.write(new Date().toString() + "  " + ex.getMessage() + "\n");
            StackTraceElement[] stackTrace = ex.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                out.write(stackTraceElement.toString() + "\n");
                out.flush();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
