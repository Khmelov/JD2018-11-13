package by.it.karnilava.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {

    public static void main(String[ ] args){
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{7,}");
        Matcher m = p.matcher(Poem.text);
        while (m.find()){
            sb.setCharAt(m.start()+6,'#');
        }
        Pattern pat = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher mat = pat.matcher(Poem.text);
        while (mat.find()){
            sb.setCharAt(mat.start()+3,'#');
        }

        System.out.println(sb.toString());
    }
}
