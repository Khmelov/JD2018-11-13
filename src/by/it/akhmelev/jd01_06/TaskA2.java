package by.it.akhmelev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA2 {

    private static String[] words = new String[0];
    private static int[] counts = new int[0];

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            process(word);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]+"="+counts[i]);
        }

    }

    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                counts[i]++;
                return;
            }
        }
        String[] words2 = new String[words.length + 1];
        int[] counts2 = new int[counts.length + 1];
        System.arraycopy(words,0,words2,0,words.length);
        System.arraycopy(counts,0,counts2,0,counts.length);
        words=words2; words[words.length-1]=word;
        counts=counts2; counts[counts.length-1]=1;
    }
}
