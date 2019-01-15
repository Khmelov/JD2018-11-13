package by.it.markelov.jd02_06.Calculator;

import java.io.File;

public class Util {

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
