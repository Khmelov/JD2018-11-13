package by.it.baidak.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static String[] words = new String[0];
    private static int[] counts = new int[0];


    public static void main(String[] args) {

        Pattern p = Pattern.compile("[а-яА-яёЁ]{2,}");
        Matcher m = p.matcher(Poem.text);
        String[] mas = new String[300];
        int counter = 0;
        while (m.find()) {
            String word = m.group();
            process(word);
        }
        for (int i = 0; i < words.length; i++) {
            if(checkLetters(words[i])) System.out.print(words[i] + " ");
        }
    }

    private static boolean checkLetters(String word) {
        if (checkCons(word.toUpperCase()) && checkVow(word.toUpperCase())) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkCons(String word) {
        switch (word.charAt(0)){
            case 'Б':
            case 'В':
            case 'Г':
            case 'Ж':
            case 'З':
            case 'К':
            case 'М':
            case 'Н':
            case 'П':
            case 'Р':
            case 'С':
            case 'Ф':
            case 'Х':
            case 'Ц':
            case 'Ч':
            case 'Ш':
            case 'Щ': return true;
            default: return false;
        }
    }

    private static boolean checkVow (String word){
        switch (word.charAt(word.length() - 1)) {
            case 'А':
            case 'Е':
            case 'Ё':
            case 'И':
            case 'О':
            case 'У':
            case 'Ы':
            case 'Э':
            case 'Ю':
            case 'Я': return true;
            default: return false;
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
