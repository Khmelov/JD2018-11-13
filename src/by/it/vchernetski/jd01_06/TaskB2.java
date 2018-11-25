package by.it.vchernetski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sd= new StringBuilder(Poem.text);
        Matcher m = Pattern.compile("[:А-яё\\s,!-]+").matcher(sd);
        String[] sen=new String[0];
        while(m.find()){
            String[] temp = new String[sen.length+1];
            System.arraycopy(sen,0,temp,0,sen.length);
            temp[sen.length]=m.group();
            sen=temp;
        }
        
    }
}
