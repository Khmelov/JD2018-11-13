package by.it.kruglenja.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 24.11.2018.
 */
public class TaskA2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        String regex = "([а-яА-ЯёЁ]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
//            String words = matcher.group();
//            process.words;
//            System.out.println(matcher.group());
//        }
//
//    }
//    private static void process(){
//        for (int i = 0; i < words.length(); i++) {
//            if (word == )
        }
    }
}
