package by.it.karnilava.calc;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LoggerErrors {
    private static LoggerErrors instance;

    private LoggerErrors(){

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

    public static void  writeReport (String string)  {
        String src = System.getProperty("user.dir") + "/src/by/it/karnilava/";
        String filename1 = src + "calc/log.txt";
        File f1 = new File(filename1);
        DataOutputStream  dos1 = null;
        try {
            dos1 = new DataOutputStream(new FileOutputStream(f1,true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
           //Записываем сообщение
            dos1.writeUTF(string+"\n");
            dos1.writeUTF("\n");
            //Записываем дату
            Date now = new Date();
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, TimeZone.LONG,Locale.getDefault());
            dos1.writeUTF(df.format(now)+"\n");
            dos1.writeUTF("\n");
            //Записываем время



        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (dos1!=null){
                try {
                    dos1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


}
