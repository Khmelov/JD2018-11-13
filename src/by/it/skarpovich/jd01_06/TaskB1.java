package by.it.skarpovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB1 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String word = matcher.group();
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);
            letters(first, last, word);
        }
    }

    private static void letters (char first, char last, String word) {
        if ((first != 'а' & first != 'е' & first != 'ё' & first != 'и' & first != 'о' & first != 'у'
                & first != 'ы' & first != 'э' & first != 'ю' & first != 'я' & first != 'А' & first != 'Е'
                & first != 'Ё' & first != 'И' & first != 'О' & first != 'У' & first != 'Ы' & first != 'Э'
                & first != 'Ю' & first != 'Я') & (last == 'а' || last == 'е' || last == 'ё' || last == 'и' ||
                last == 'о' || last == 'у' || last == 'ы' || last == 'э' || last == 'ю' || last == 'я'))
            System.out.println(word + " ");
    }
}