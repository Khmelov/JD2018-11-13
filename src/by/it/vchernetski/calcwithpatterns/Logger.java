package by.it.vchernetski.calcwithpatterns;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger logger;
    private Logger(){}
    static Logger getInstance(){
        if(logger==null){
            synchronized (Logger.class){
                if(logger==null)logger = new Logger();
            }
        }
        return logger;
    }
    synchronized void log(String text){
        String path = Util.getPath("log.txt");
        try(BufferedWriter out = new BufferedWriter(new FileWriter(path,true))){
            out.write(text+"\n");
            out.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
