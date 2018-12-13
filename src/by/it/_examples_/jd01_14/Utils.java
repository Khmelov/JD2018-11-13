package by.it._examples_.jd01_14;

/**
 * Created by Alex on 05.06.2016.
 */
public class Utils {
    static String getFilePath(String name) {
        String src = System.getProperty("user.dir") + "/src/by/it/_examples_/jd01_14/";
        return src + name;
    }
}
