package by.it.seroglazov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words = new String[0];
    private static int[] counts = new int[0];

    public static void main(String[] args) {
        parseToWords(Poem.text);
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + '=' + counts[i]);
        }
    }

    static void parseToWords(String str){
        StringBuilder sb = new StringBuilder(str);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(str);
        while (m.find()) {
            processingWord(m.group());
        }
    }

    private static void processingWord(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])){
                counts[i]++;
                return;
            }
        }
        String[] newWords = new String[words.length + 1];
        System.arraycopy(words, 0, newWords, 0, words.length);
        newWords[newWords.length - 1] = word;
        words = newWords;
        int[] newCounts = new int[counts.length + 1];
        System.arraycopy(counts, 0, newCounts, 0, counts.length);
        newCounts[newCounts.length - 1] = 1;
        counts = newCounts;
    }

    static String[] getStrings(){
        String[] newWords = new String[words.length];
        System.arraycopy(words, 0, newWords, 0, words.length);
        return newWords;
    }
}
























