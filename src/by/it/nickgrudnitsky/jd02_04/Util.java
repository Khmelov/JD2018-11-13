package by.it.nickgrudnitsky.jd02_04;

import java.io.File;

public class Util {

    private Util() {
    }

    static String getPath(Class<?> clazz) {
        String simpleName = clazz.getSimpleName();
        String path = clazz.getName().replace(simpleName, "");
        path = path.replaceAll("\\.", File.separator);
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

    public static void main(String[] args) {
        System.out.println(getPath("data.bim"));
    }
}
