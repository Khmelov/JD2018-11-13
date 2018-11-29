package by.it.skarpovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern p1=Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher m1=p1.matcher(Poem.text);
        while(m1.find()){
            int start = m1.start();
            sb.setCharAt(start+3,'#');
            if (m1.group().length()>=7) { sb.setCharAt(start+6,'#');}
            }
            System.out.println(sb);
    }
}
