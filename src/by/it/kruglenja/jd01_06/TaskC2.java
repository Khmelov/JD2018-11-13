package by.it.kruglenja.jd01_06;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        long t1 = System.nanoTime();
        String slow1 = slow(Poem.text);
        long t2 = System.nanoTime();
        System.out.println(slow1);


        long t3 = System.nanoTime();
        String fast = fast(Poem.text);
        long t4 = System.nanoTime();
        System.out.println(slow1);
        System.out.println();
        System.out.println("Slow was :" + (t2 - t1)/1000000 + "мс"); ;
        System.out.println("Fast was :" + (t4 - t3)/1000000 + "мс"); ;

    }

    private static String slow(String text) {
        String[] wordString = new String[0];
        Pattern pattern = Pattern.compile("[А-яёЁ]+");
        Matcher matcher = pattern.matcher(text);
        Random random = new Random(228);
        while (matcher.find()) {
            String[] temp = new String[wordString.length + 1];
            System.arraycopy(wordString, 0, temp, 0, wordString.length);
            temp[wordString.length] = matcher.group();
            wordString = temp;
        }
        String slowstr = " ";
        while (slowstr.length() < 100000) {
            slowstr += wordString[random.nextInt(wordString.length)];
            slowstr += " ";
        }
        return slowstr;
    }

    private static String fast(String text) {
        Random random = new Random(228);
        String[] words = new String[0];
        Matcher m = Pattern.compile("[А-яё]+").matcher(text);
        while (m.find()) {
            String[] temp = new String[words.length + 1];
            System.arraycopy(words, 0, temp, 0, words.length);
            temp[words.length] = m.group();
            words = temp;
        }
        StringBuilder sb = new StringBuilder(" ");
        while (sb.length() < 100000) {
            sb.append(words[random.nextInt(words.length)]);
            sb.append(" ");
        }
        String fin = sb.toString();
        return fin;
    }
}
