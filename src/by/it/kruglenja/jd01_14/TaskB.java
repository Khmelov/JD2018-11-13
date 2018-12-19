package by.it.kruglenja.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {
    private static int wordCount = 0;
    private static int markCount = 0;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String pathRead = Util.getPath("text.txt");
        String pathWrite = Util.getPath("resultTaskB.txt");

        try {
            elementCounter(readFile(sb, pathRead));
            String resultString = "words=" + wordCount + ", punctuation marks=" + markCount;
            consolePrinter(resultString);
            filePrinter(resultString, pathWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder readFile(StringBuilder sb, String path) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb;
    }

    private static void elementCounter(StringBuilder sb) {
        Pattern patternWord = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcherWord = patternWord.matcher(sb);

        Pattern patternMark = Pattern.compile("[^а-яА-ЯёЁ\\s]+");
        Matcher matcherMark = patternMark.matcher(sb);

        for (int i = 0; i < sb.length(); i++) {
            if (matcherWord.find()) {
                wordCount++;
            } else if (matcherMark.find()) {
                markCount++;
            }
        }
    }

    private static void consolePrinter(String string) {
        System.out.println(string);
    }

    private static void filePrinter(String string, String path) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.print(string);
        }
    }
}
