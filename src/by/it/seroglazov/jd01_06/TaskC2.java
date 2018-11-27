package by.it.seroglazov.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {

    public static void main(String[] args) {
        runSlow();
        runFast();
    }

    private static void runSlow(){
        long t1 = System.nanoTime();
        String s1 = slow(Poem.text);
        long t2 = System.nanoTime();
        System.out.println(s1);
        double t = (t2 - t1) / 1.0e6;
        System.out.println(t + " мс");
    }

    private static void runFast(){
        long t1 = System.nanoTime();
        String s1 = fast(Poem.text);
        long t2 = System.nanoTime();
        System.out.println(s1);
        double t = (t2 - t1) / 1.0e6;
        System.out.println(t + " мс");
    }

    private static String[] getWords(String text){
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(text);
        int counter = 0;
        while (m.find()) counter++;
        m.reset();
        String[] words = new String[counter];
        int i = 0;
        while (m.find()) {
            words[i++] = m.group();
        }
        return words;
    }

    static String slow(String text) {
        String[] words = getWords(text);
        Random r = new Random(30181113);
        String out = new String();
        while (out.length() < 100000) {
            out = out.concat(words[r.nextInt(words.length)]);
            out = out.concat(" ");
        }
        return out;
    }

    static String fast(String text){
        String[] words = getWords(text);
        Random r = new Random(30181113);
        StringBuilder sb = new StringBuilder(100000);
        while (sb.length() < 100000) {
            sb.append(words[r.nextInt(words.length)]);
            sb.append(' ');
        }
        return sb.toString();
    }
}






























