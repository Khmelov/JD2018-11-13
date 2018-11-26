package by.it.malishevskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] w = new String[0];
    private static int[] counts = new int[0];

    public static void main(String[] args) {
        parseToWords(Poem.text);
        for (int i = 0; i < w.length; i++) {
            System.out.println(w[i] + '=' + counts[i]);
        }
    }

    static void parseToWords(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(str);
        while (m.find()) {
            processingWord(m.group());
        }
    }

    private static void processingWord(String word) {
        for (int i = 0; i < w.length; i++) {
            if (word.equals(w[i])){
                counts[i]++;
                return;
            }
        }
        String[] newWords = new String[w.length + 1];
        System.arraycopy(w, 0, newWords, 0, w.length);
        newWords[newWords.length - 1] = word;
        w = newWords;
        int[] newCounts = new int[counts.length + 1];
        System.arraycopy(counts, 0, newCounts, 0, counts.length);
        newCounts[newCounts.length - 1] = 1;
        counts = newCounts;
    }

    static String[] getStrings(){
        String[] newW = new String[w.length];
        System.arraycopy(w, 0, newW, 0, w.length);
        return newW;
    }
}
