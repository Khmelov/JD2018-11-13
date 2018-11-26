package by.it.markelov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder(Poem.text);
//      System.out.println(s + "\n");

        Pattern pat = Pattern.compile("[[А-Я]Ё[а-я]ё]+");
        Matcher mat = pat.matcher(s);
        while (mat.find()) {
            String word = mat.group();
            char start = word.charAt(0);
            char end = word.charAt(word.length() - 1);
            checkcodition(start, end, word);
            }
        }

    private static void checkcodition (char start, char end, String word) {
        if ((start != 'а' & start != 'е' & start != 'ё' & start != 'и' & start != 'о' & start != 'у' & start != 'ы'
                & start != 'э' & start != 'ю' & start != 'я' & start != 'А' & start != 'Е'
                & start != 'Ё' & start != 'И' & start != 'О' & start != 'У' & start != 'Ы' & start != 'Э'
                & start != 'Ю' & start != 'Я') & (end == 'а' || end == 'е' || end == 'ё' || end == 'и' ||
                end == 'о' || end == 'у' || end == 'ы' || end == 'э' || end == 'ю' || end == 'я'))
            System.out.println(word + " ");

        }

    }