package by.it.mnovikov.jd02_06;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

class Logger {

    private static volatile Logger logger;

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

    synchronized void log(String text) {
        Date currentDate = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM);

        try (
                BufferedWriter out = new BufferedWriter(
                        new FileWriter("E:\\Java\\JD2018-11-13\\src\\by\\it\\mnovikov\\jd02_06\\log.txt", true))) {
            out.write(df.format(currentDate) + " " + text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
