package by.it.nickgrudnitsky.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class Logger {
    private static Logger instanse;

    private Logger() {

    }

    public static Logger getInstance() {
        if (instanse == null) {
            instanse = new Logger();
        }
        return instanse;
    }

    private File file = new File(System.getProperty("user.dir"), "src/by/it/nickgrudnitsky/calc/log.txt");

    public void log(String error) {

        try (
                BufferedWriter out = new BufferedWriter(
                        new FileWriter(file, true)
                )) {
            out.write(error + " - ");
            DateFormat dateFormat = DateFormat.getDateTimeInstance();
            String date = dateFormat.format(new Date());
            out.write(date + "\n");
            out.flush();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
