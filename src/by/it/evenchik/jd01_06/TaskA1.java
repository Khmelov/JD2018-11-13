package by.it.evenchik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String [] args){
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern =  Pattern.compile( "[А-Яа-яёйЁЙ]{4,}");
        Pattern patAllWords =  Pattern.compile( "[А-Яа-яёйЁЙ]+");

        Matcher matcher = pattern.matcher(Poem.text);
        Matcher matchForCount = patAllWords.matcher(Poem.text);


        while (matcher.find()){
            int start = matcher.start();
            sb.setCharAt(start+3,'#');
            if (matcher.group().length()>=7 ){

                System.out.println("-----------------"+ matcher.group());
                sb.setCharAt(start+6, '#');
            }

        }
        System.out.println(sb);


    }

}
