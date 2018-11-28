package by.it.burlakov.jd01_06;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TaskA1 {



        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder(Poem.text);
            Pattern pattern = Pattern.compile("[а-яА-яёЁ]{4,}");
            Matcher matcher = pattern.matcher(Poem.text);

            while (matcher.find()) {
                int start = matcher.start();
                sb.setCharAt(start + 3, '#');

                if (matcher.group().length() >= 7)
                    sb.setCharAt(matcher.start() + 6, '#');
            }
            System.out.println(sb.toString());
        }

}
