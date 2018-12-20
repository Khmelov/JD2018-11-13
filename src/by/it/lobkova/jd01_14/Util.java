package by.it.lobkova.jd01_14;

import java.io.File;

public class Util {

    private Util() {

    }

    static String getPath(Class<?> cl) {
        String className = cl.getSimpleName();
        String path = cl.getName().replace(className, "");
        path = path.replace(".", File.separator);
        String systemPath = System.getProperty("user.dir");
        String root = systemPath + File.separator + "src" + File.separator + path;
        return root;
    }

    static String getPath() {
        return getPath(Util.class);
    }

    public static String getPath(String filename) {
        return getPath() + filename;
    }
}
