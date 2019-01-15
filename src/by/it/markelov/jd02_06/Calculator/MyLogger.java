package by.it.markelov.jd02_06.Calculator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class MyLogger {

    private MyLogger() {
    }

    private static MyLogger instance;

    public static synchronized MyLogger getInstance() {
        if (instance == null) {
            instance = new MyLogger();
        }
        return instance;
    }

    public void printToFile(String text) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new FileWriter(Path.pathOfThisDirectory(MyLogger.class) + File.separator + "logCalc.txt", true))) {
            bufferedWriter.write(new Date() + " ===> " + text + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

