package by.it.seroglazov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(Poem.text);
        while (m.find()){
            int pos = m.start();
            int len = m.end() - pos;
            if (len >= 4) sb.setCharAt(pos + 3, '#');
            if (len >= 7) sb.setCharAt(pos + 6, '#');
        }
        System.out.println(sb.toString());
    }


}
