package by.it.mnovikov.calc2;

import java.io.File;

public class Util {

    private Util() {
    }

    static String getPath(Class<?> clazz) {
        String simpleName = clazz.getSimpleName();
        String path = clazz.getName().replace(simpleName, "");
        path = path.replace(".", File.separator);
        String root = System.getProperty("user.dir");

        return root + File.separator + "src" + File.separator + path;
    }

    static String getPath() {
        return getPath(Util.class);
    }

    static String getPath(String filename) {
        return getPath() + filename;
    }
}
