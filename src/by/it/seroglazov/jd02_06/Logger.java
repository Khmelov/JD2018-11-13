package by.it.seroglazov.jd02_06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    synchronized void add(String text) throws IOException {
        String userDir = System.getProperty("user.dir");
        File file = new File(userDir, "by/it/seroglazov/jd02_06/log.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.write(text);
            bw.newLine();
            bw.flush();
        }
    }
}
