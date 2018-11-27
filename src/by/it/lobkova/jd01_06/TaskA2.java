package by.it.lobkova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words = new String[0];
    private static int[] counts = new int[0];

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[ф-яА-яёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
           // process(word);
        }


    }

  /*  private static void process(String word){
        for (int i = 0; i < words.length(); i++) {
            if (word words[i]){
                counts[i]++;
                return;
            }
        }
        String[] words2 = new String[words2.length + 1];
        int[] counts2 = new int[counts.length + 1];
        System.arraycopy(words, 0, counts, 0, counts.length);
    }*/
}
