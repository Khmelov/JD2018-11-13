package by.it.medvedeva.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


    import java.util.regex.*;

    public class TaskB1 {
        private static boolean testSogl(String word) {
            String gl = "АЕЁИОУЫЭЮЯаеёиоуыэюя";
            char a = word.charAt(0);
            for (int i=0; i<gl.length(); i++) {
                if (a == gl.charAt(i)) {
                    return false;
                }
            }
            a = word.charAt(word.length()-1);
            Boolean test = false;
            for (int i=0; i<gl.length(); i++) {
                if (a == gl.charAt(i)) {
                    test = true;
                }
            }
            return test;
        }


        public static void main(String[] args) {

            Pattern pword = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcher = pword.matcher(Poem.text);
            while (matcher.find()) {
                String word = matcher.group();
                if (testSogl(word)) {
                    System.out.println(word);
                }
            }
        }
    }


