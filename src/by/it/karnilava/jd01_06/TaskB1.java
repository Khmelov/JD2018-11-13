package by.it.karnilava.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static String[] w = {};
    private static char[] a = {'А', 'а', 'Е', 'е', 'Ё', 'ё', 'И', 'и', 'О', 'о', 'У', 'у', 'Ю', 'ю', 'Э', 'э', 'Я', 'я', 'Ы', 'ы'};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            suitable(word);


        }

    }




    private static void suitable(String word) {

        boolean isThereAnyVowel = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == word.charAt(0)) {
                isThereAnyVowel = true;
            }
        }

        if (isThereAnyVowel == false) {

            for (int j = 0; j < a.length; j++) {
                if (word.charAt(word.length() - 1) == a[j]) {
                    System.out.println(word);
                    return;

                }
            }


        }


    }


}
