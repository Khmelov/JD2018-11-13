package by.it.kruglenja.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(sb);

        int len = 0;
        while (matcher.find()) {
            len++;
        }
        matcher.reset();
        int[] counter = new int[len];
        String[] words = new String[len];

        while (matcher.find()) {
            for (int i = 0; i < words.length; i++) {
                if (words[i] == null) {
                    words[i] = matcher.group();
                    counter[i]++;
                    break;
                } else if (words[i].equals(matcher.group())) {
                    counter[i]++;
                    break;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (words[i] != null) {
                System.out.println(words[i] + "=" + counter[i]);
            }
        }
    }
}
