package by.it.seroglazov.jd02_06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

public class Logger {
    private static volatile Logger instance;

    private Logger() {
    }

    static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    private File file = new File(System.getProperty("user.dir"), "src/by/it/seroglazov/jd02_06/log.txt");

    synchronized void add(String text) {
        DateFormat df = DateFormat.getDateTimeInstance();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            String dt = df.format(new Date());
            bw.write(dt);
            bw.write(" - ");
            bw.write(text);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
