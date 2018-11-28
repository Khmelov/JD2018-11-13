package by.it.markelov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder(Poem.text);
        System.out.println(s + "\n");

        Pattern pat = Pattern.compile("[[А-Я]Ё[а-я]ё]{4,}");
        Matcher mat = pat.matcher(s);
        while (mat.find()) {
            s.setCharAt(mat.start() + 3, '#');
        }
        System.out.println(s + "\n");


        pat = Pattern.compile("[[А-Я]Ё[а-я]ё#]{7,}");
        mat = pat.matcher(s);
        while (mat.find()) {
            s.setCharAt(mat.start() + 6, '#');
        }
        System.out.println(s + "\n");

    }


}
