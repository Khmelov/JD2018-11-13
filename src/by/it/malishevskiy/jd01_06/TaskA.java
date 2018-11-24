package by.it.malishevskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ](4,)");
        Matcher m = p.matcher(Poem.text);
        while (m.find()) {
            int pos = m.start();
            sb.setCharAt(pos + 3, '#');
        }
    }
}
