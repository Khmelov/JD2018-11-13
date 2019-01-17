package by.it.karnilava.jd02_06;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LoggerErrors {
    private static LoggerErrors instance;

    private LoggerErrors() {

    }

    public static LoggerErrors getInstance() {
        LoggerErrors localInstance = instance;
        if (localInstance == null) {
            synchronized (LoggerErrors.class) {
                instance = localInstance = new LoggerErrors();
            }
        }


        return localInstance;
    }

    public static void writeReport(String string) {
        String src = System.getProperty("user.dir") + "/src/by/it/karnilava/";
        String filename1 = src + "jd02_06/log.txt";
        File f1 = new File(filename1);
        DataOutputStream dos1 = null;
        try {
            dos1 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f1, true)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //Записываем сообщение

            dos1.writeUTF(string + "\n");
            //Записываем дату
            Date now = new Date();
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, TimeZone.LONG, Locale.getDefault());
            dos1.writeUTF(df.format(now) + "\n");
            //Записываем время


        } catch (IOException e) {
            e.printStackTrace();
        }
        if (dos1 != null) {
            try {
                dos1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
