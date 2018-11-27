package by.it.mnovikov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 24.11.2018.
 */
public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        String regex = "[а-яА-ЯёЁ]{4,}+";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(Poem.text);

        while (m1.find()) {
            sb.setCharAt(m1.start()+3, '#');
            if (m1.group().length()>=7){
                sb.setCharAt(m1.start()+6, '#');
            }
        }
        System.out.println(sb.toString());
    }
}
