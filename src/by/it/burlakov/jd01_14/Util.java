package by.it.burlakov.jd01_14;

import java.io.File;

/**
 * Created by user on 13.12.2018.
 */
public class Util {
    static String getPath(Class<?> cl){
        String simName = cl.getSimpleName();
        String path =  cl.getName().replace(simName,"");
        path = path.replace(".", File.separator);
        String root = System.getProperty("user.dir");
        String result = root + File.separator + "scr" + File.separator + path;
        return result;
    }

    static String getPath(){
        return getPath(Util.class);
    }
    static String getPath(String string){
        return getPath(Util.class) + string;
    }

    public static void main(String[] args) {
        System.out.println(getPath("sfsdf"));
    }
}
