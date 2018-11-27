package by.it.lobkova.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern p = Pattern.compile("[а-яА-яёЁ]{4,}");
        Matcher m = p.matcher(Poem.text);
        while (m.find()){
            sb.setCharAt(m.start(), '#'); //hhh
          //  if (m.group().length()>= 7) sb.setCharAt((pos + 6), '#');
        }
        System.out.println(sb.toString());
    }
}
