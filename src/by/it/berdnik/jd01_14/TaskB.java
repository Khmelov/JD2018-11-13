package by.it.berdnik.jd01_14;

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class TaskB {

    public static void main(String[] args) {
        int words = 0;
        int sign = 0;

        try {
            File file = new File(dir(TaskB.class) + "text.txt");
            Scanner scanner = new Scanner(file);
            Pattern patword = Pattern.compile("[А-Яа-яЁё]+");
            Pattern signs = Pattern.compile("[.,?!:;]");

            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                Matcher matcher = patword.matcher(string);
                while (matcher.find()) {
                    words++;
                }
                matcher = signs.matcher(string);
                while (matcher.find()) {
                    sign++;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            String string = "words=" + String.valueOf(words) + ", punctuation marks=" + String.valueOf(sign);
            PrintWriter outprint = new PrintWriter(new FileWriter(dir(TaskB.class) + "resultTaskB.txt"));
            System.out.println(string);
            outprint.println(string);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String dir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return path + dir;
    }
}