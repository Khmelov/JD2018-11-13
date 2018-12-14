package by.it.nickgrudnitsky.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static StringBuilder sb = new StringBuilder(1000);
    public static void main(String[] args) throws IOException {
        calc();
        write();
    }

    private static void write() throws IOException {
        try (FileWriter wrtr = new FileWriter(Util.getPath("resultTaskB.txt"));
             BufferedWriter bwrtr = new BufferedWriter(wrtr)){
            Pattern pattern = Pattern.compile("[А-Яа-яёЁ]+");
            Matcher matcher = pattern.matcher(sb);
            int words = 0;
            while (matcher.find()) {
                words++;
            }
            Pattern pattern1 = Pattern.compile("[.,!?:-]+");
            Matcher matcher1 = pattern1.matcher(sb);
            int marks = 0;
            while (matcher1.find()) {
                marks++;
            }
            bwrtr.write("words=");
            bwrtr.write(String.valueOf(words));
            bwrtr.write(", punctuation marks=");
            bwrtr.write(String.valueOf(marks));
        }
    }

    private static void calc() throws IOException {
        try (FileReader rdr = new FileReader(Util.getPath("text.txt"));
             BufferedReader brdr = new BufferedReader(rdr)
        ) {
            int b;
            while ((b = brdr.read()) != -1) {
                sb.append((char) b);
            }
            Pattern pattern = Pattern.compile("[А-Яа-яёЁ]+");
            Matcher matcher = pattern.matcher(sb);
            int words = 0;
            while (matcher.find()) {
                words++;
            }
            Pattern pattern1 = Pattern.compile("[.,!?:-]+");
            Matcher matcher1 = pattern1.matcher(sb);
            int marks = 0;
            while (matcher1.find()) {
                marks++;
            }
            System.out.println("words="+words +", punctuation marks=" + marks);
        }
    }
}
