package by.it.kruglenja.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 24.11.2018.
 */
public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        String regex = "([а-яА-ЯёЁ]{4,})";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sb);

        while (m.find()){
            sb.setCharAt(m.start() + 3, '#');
            if (m.group().length() >=7)
            sb.setCharAt(m.start() + 6, '#');
        }
        System.out.println(sb.toString());
    }
}
