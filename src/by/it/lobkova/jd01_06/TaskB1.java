package by.it.lobkova.jd01_06;

import java.util.regex.Pattern;

public class TaskB1 {
    static final String CONSONANTS = "цкнгшщзхъфвпрлджчсмтбьй";
    static final String VOWELS = "уеыаоэяиюё";
    static String[] words = new String[0];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        String[] words = sb.toString().split("[,;:.!?\\s]+");

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 1) {
                if (checkWord(words[i])){
                    System.out.println(words[i]);
                }
            }
        }

    }

    public static boolean checkWord(String word) {
        if ((CONSONANTS.indexOf(word.toLowerCase().charAt(0)) != -1) &&
                (VOWELS.indexOf(word.toLowerCase().charAt(word.length() - 1)) != -1)) {
            return true;
        } else return false;
    }
}
