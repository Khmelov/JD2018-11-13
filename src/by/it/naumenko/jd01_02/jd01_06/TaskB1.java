package by.it.naumenko.jd01_02.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        String text = new String(Poem.text);
        String[] wordArray = text.split("[\\s,.:!?]+");
        Pattern pattern = Pattern.compile("^[^аоэиуыеёюяАОЭИУЫЕЁЮЯ][а-яё]+[аоэиуыеёюя]$");
        int col = 0;
        for (String word : wordArray) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                System.out.println(word);
                col++;
            }
        }
        System.out.println(col);
    }
}
