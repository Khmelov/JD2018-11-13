package by.it.skarpovich.calc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    synchronized void log(String text) {
        try (
                BufferedWriter out = new BufferedWriter(
                        new FileWriter(Util.getPath("log.txt"),true)
                )) {



            Date d = new Date();
            DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, ResMan.INSTANCE.getLocale());

            out.write(text + " " + dateFormat.format(d)+ "\n");
            out.flush();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
