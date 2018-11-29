package by.it.nickgrudnitsky.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        start1();
        start2();
    }

    private static void start2() {
        String sb = Poem.text;
        long startTime = System.nanoTime();
        String text = fast(sb);
        long endTime = System.nanoTime();
        double testTime = (endTime - startTime) / 1000000.0;
        System.out.println(text);
        System.out.println(testTime);
    }

    private static void start1() {
        String sb = Poem.text;
        long startTime = System.nanoTime();
        String text = slow(sb);
        long endTime = System.nanoTime();
        double testTime = (endTime - startTime) / 1000000.0;
        System.out.println(text);
        System.out.println(testTime);
    }

    private static String fast(String text) {
        String[] words = getWords(text);
        Random r = new Random(1);
        StringBuilder sb = new StringBuilder(100000);
        while (sb.length() < 100000) {
            sb.append(words[r.nextInt(words.length)]);
            sb.append(" ");
        }
        return sb.toString();
    }

    private static String slow(String text) {
        String[] words = getWords(text);
        Random r = new Random(1);
        String sb = "";
        while (sb.length() < 100000) {
            sb = sb.concat(words[r.nextInt(words.length)]);
            sb = sb.concat(" ");
        }
        return sb;
    }

    private static String[] getWords(String text) {
        String[] string = new String[0];
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(text);
        int i = 0;
        while (matcher.find()) {
            int last = string.length;
            string = Arrays.copyOf(string, last + 1);
            string[i] = matcher.group();
            i++;
        }
        return string;
    }


}
