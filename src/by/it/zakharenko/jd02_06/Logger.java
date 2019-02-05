package by.it.zakharenko.jd02_06;

import by.it.zakharenko.jd01_14.Util;
import java.text.DateFormat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
    private Logger(){
    }

    private static Logger log;
    public static Logger getLogger(){
        if (log == null){
            synchronized (Logger.class){
                if(log == null) {
                    log = new Logger();
                }
            }
        }
        return log;
    }

    synchronized void writeLog(String tx){
        Date data = new Date();
        DateFormat dataFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.MEDIUM);
        try (
                BufferedWriter out = new BufferedWriter(
                        new FileWriter("log1.txt" , true)
                )) {
            out.write(dataFormat.format(data) + " " + tx +"\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
