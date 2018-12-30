package by.it.seroglazov.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskB {
    /**
     * Метод main, который выводит на экран
     * текст этой программы без комментариев
     * @param args
     */
    public static void main(String[] args) {
        String part1 = System.getProperty("user.dir");
        String part2 = "/src/by/it/seroglazov/jd01_15";
        Path pathJ = Paths.get(part1, part2, "TaskB.java");
        Path pathT = Paths.get(part1, part2, "TaskB.txt");
        StringBuilder sb = new StringBuilder(); // Reading file
        try (BufferedReader reader = new BufferedReader(new FileReader(pathJ.toFile()))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (FileNotFoundException e) {
            System.err.println("Не найден файл " + pathJ.toString());
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла " + pathJ.toString());
        }
        /* Parsing file
           Use new StringBuilder variable
           to do this */
        StringBuilder sb2 = new StringBuilder();
        char prev = 0;
        boolean inOneLineComment = false; // Мы в однострочном комментарии
        boolean inMulLineComment = false; // Мы в многострочном комментарии
        if (sb.length() > 0) {
            prev = sb.charAt(0);
            sb2.append(prev);
            for (int i = 1; i < sb.length(); i++) {
                char a = sb.charAt(i);
                if (inOneLineComment) {
                    if (a == '\n') {
                        inOneLineComment = false;
                        sb2.append(a);
                    }
                } else if (inMulLineComment) {
                    if (a == '/' && prev == '*') inMulLineComment = false;
                } else {
                    if (a == '*' && prev == '/') {
                        inMulLineComment = true;
                        sb2.deleteCharAt(sb2.length() - 1);
                    } else if (a == '/' && prev == '/') {
                        inOneLineComment = true;
                        sb2.deleteCharAt(sb2.length() - 1);
                    } else sb2.append(a);
                }
                prev = a;
            }
        }
        /* Write to file
        * now*/
        System.out.println(sb2);
        try (PrintWriter pw = new PrintWriter(new FileWriter(pathT.toString()))) {
            pw.write(sb2.toString());
        } catch (IOException e) {
            System.err.format("Ошибка записи файла %s%n", pathT);
        }
    }
}