package by.it.lobkova.jd01_15;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    static String filename = Util.getPath("TaskB.java");

    private static String pathPackage(Class<?> clazz) {
        String simpleName = clazz.getSimpleName();
        String path = clazz.getName().replace(simpleName, "");
        path = path.replace(".", File.separator);
        String root = System.getProperty("user.dir");
        String result = root + File.separator + "src" + File.separator + path;
        return result;
    }

    public static void main(String[] args) {
        //dfsfdsfdfsdf

        //sdfdfdsfsd
        StringBuilder sb = new StringBuilder(); //sdfdsfdsfdsfdsfdsf
        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename)))/* */ {
            while (reader.ready()) {
                char ch = (char) reader.read();

                /*
                sadsad
                d/asd
                *
                *
                * /ds
                 */

                if (ch == '/') {
                    ch = (char) reader.read();
                    if (ch == '/') {
                        reader.readLine();
                        sb.append("\r\n");
                        continue;
                    }
                    /**
                     * JavaDoc comment
                     *
                     * @param args
                     */

                    if (ch == '*') {
                        while (reader.ready()) {
                            ch = (char) reader.read();
                            if (ch == '*' && reader.read() == '/') {
                                break;
                            }
                        }
                        continue;
                    }
                    sb.append('/');
                }
                sb.append(ch);

                System.out.println(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(pathPackage(TaskB.class) + File.separator + "TaskB.txt")) {
            writer.print(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
