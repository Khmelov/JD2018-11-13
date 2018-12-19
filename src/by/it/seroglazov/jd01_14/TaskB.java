package by.it.seroglazov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        File tarf = TaskA.getTargetFile("text.txt");
        String text = "";
        try (BufferedReader stream = new BufferedReader(new FileReader(tarf))) {
            StringBuilder sb = new StringBuilder();
            int chInt;
            while ((chInt = stream.read()) != -1) {
                char ch = (char) chInt;
                sb.append(ch);
            }
            text = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher punct = Pattern.compile("[.]{3}|[\\.,!?:;\\-]").matcher(text);
        int punctCount = 0;
        while (punct.find()) punctCount++;
        int wordCount = 0;
        Matcher words = Pattern.compile("[а-яА-ЯёЁ]+").matcher(text);
        while (words.find()) wordCount++;
        String outStr = "words=" + wordCount + ", punctuation marks=" + punctCount;
        System.out.println(outStr);
        // write to file
        tarf = TaskA.getTargetFile("resultTaskB.txt");
        writeToFile(tarf, outStr);
    }

    static void writeToFile(File f, String outStr) {
        try (BufferedWriter stream = new BufferedWriter(new FileWriter(f))) {
            stream.write(outStr);
        } catch (IOException e) {
            System.out.println("Не могу записать файл " + f.getAbsolutePath());
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
