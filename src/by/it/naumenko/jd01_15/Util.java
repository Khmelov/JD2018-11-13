package by.it.naumenko.jd01_15;

import java.io.File;

public class Util {
    private Util() { }

//    static String dir(Class<?> clazz) {
//        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
//        String classDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
//        return path + classDir;
//    }

    static String getPath(Class<?> clazz) {
        String simpleName = clazz.getSimpleName();
        String path = clazz.getName().replace(simpleName, "");
        path = path.replace(".", File.separator);
        String root = System.getProperty("user.dir");
        String result = root + File.separator + "src" + File.separator + path;
        return result;
    }

    static String getPath() {
        return getPath(Util.class);
    }

    static String getPath(String fileName) {
        return getPath() + fileName;
    }
}
