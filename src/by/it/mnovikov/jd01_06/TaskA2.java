package by.it.mnovikov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 24.11.2018.
 */
public class TaskA2 {

    private static String[] words = new String[0];
    private static int[] counts = new int[0];

    static void main(String[] args) {
        String regex = "[а-яА-ЯёЁ]+";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(Poem.text);

        while (m1.find()) {
            String word = m1.group();
            int p = process(word);
            if (p >= 0) {
                counts[p]++;
            } else {
                int last = words.length;
                words = Arrays.copyOf(words, last + 1);
                words[last] = word;
                counts = Arrays.copyOf(counts, last + 1);
                counts[last] = 1;
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]+"="+counts[i]);
        }
    }

    private static int process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word))
                return i;
        }
        return -1;
    }
}
