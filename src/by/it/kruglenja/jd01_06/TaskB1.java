package by.it.kruglenja.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        consonants();
    }

    private static void consonants() {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(sb);
        String[] letters = {"а", "е", "ё", "и", "о", "у", "ы", "э", "ю", "я"};
        while (matcher.find()) {
            boolean skip = true;
            for (int i = 0; i < letters.length; i++) {
                Character s = sb.toString().charAt(matcher.start());
                Character e = sb.toString().charAt(matcher.end()-1);
                if (s.toString().equalsIgnoreCase(letters[i])){
                    break;
                }
                if (e.toString().equalsIgnoreCase(letters[i])){
                    skip = false;
                }
                if (i == letters.length-1 && !s.toString().equalsIgnoreCase(letters[i]) && !skip){
                    System.out.println(matcher.group());
                    break;
                }
            }
        }
    }
}

