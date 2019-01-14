package by.it.zhivov.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {

    private static String slow (String text){
        Random rand = new Random(1);
        String[] words = new String[0];
        Matcher m = Pattern.compile("[А-яё]+").matcher(text);
        while (m.find()){
            String[] temp = new String[words.length+1];
            System.arraycopy(words,0,temp,0,words.length);
            temp[words.length] = m.group();
            words = temp;
        }
        String slowstr = " ";
        while (slowstr.length()<100000) {
            slowstr += words[rand.nextInt(words.length)];
            slowstr += " ";
        }
        return slowstr;
    }
    private  static String fast(String text){
        Random rand = new Random(1);
        String[] words = new String[0];
        Matcher m = Pattern.compile("[А-яё]+").matcher(text);
        while (m.find()){
            String[] temp = new String[words.length+1];
            System.arraycopy(words,0,temp,0,words.length);
            temp[words.length] = m.group();
            words = temp;
        }
        StringBuilder sb = new StringBuilder(" ");
        while(sb.length()<100000){
            sb.append(words[rand.nextInt(words.length)]);
            sb.append(" ");
        }
        String fin = sb.toString();
        return fin;
    }
    public static void main(String[] args) {
        String slowstr = slow(Poem.text);
        System.out.println(slowstr);
        String faststr = fast(Poem.text);
        System.out.println(faststr);
    }
}
