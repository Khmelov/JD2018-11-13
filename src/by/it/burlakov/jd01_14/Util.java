package by.it.burlakov.jd01_14;

import java.io.File;

/**
 * Created by user on 13.12.2018.
 */
public class Util {
        private Util() {
    }
    static String getPath(Class<?> cl, boolean isShort){
        String result = "";
        String simName = cl.getSimpleName();
        String path =  cl.getName().replace(simName,"");
        path = path.replace(".", File.separator);
        String root = System.getProperty("user.dir");
        if(isShort){
            result = root + File.separator + "src";
        } else {
            result = root + File.separator + "src" + File.separator + path;
        }

        return result;
    }

    static String getPath(boolean isShort){
        return getPath(Util.class, isShort);
    }

    static String getPath(String string, boolean isShort){
        return getPath(isShort) + string;
    }

}