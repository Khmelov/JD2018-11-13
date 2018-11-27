package by.it.burlakov.jd01_06;

import java.util.regex.Pattern;

public class TaskC2 {
    private static int[] indexArray = new int[10000];// на 100000 тормозит

    public static void main(String[] args) {
        long startSlow = System.currentTimeMillis();
        System.out.println(slow(Poem.text));
        long endSlow = System.currentTimeMillis();

        long startFast = System.currentTimeMillis();
        System.out.println(fast(Poem.text));
        long endFast = System.currentTimeMillis();

        long deltaSlow = (endSlow - startSlow);
        long deltaFast = (endFast - startFast);

        System.out.println("Slow = " + deltaSlow);
        System.out.println("Fast = " + deltaFast);

    }

    private static String slow(String text) {
        int index;
        StringBuilder sb = new StringBuilder(text);
        Pattern pat = Pattern.compile("[^а-яёА-ЯЁ]+");
        String[] wordsArray = pat.split(sb);

        String str = "";
        for (int i = 0; i < 10000; i++) {
            index = (int)(Math.random() * wordsArray.length);
            indexArray[i] = index;
            str += wordsArray[index] + " ";
        }
        return str;
    }

    private static String fast(String text) {
        StringBuilder sb = new StringBuilder(text);
        Pattern pat = Pattern.compile("[^а-яёА-ЯЁ]+");
        String[] wordsArray = pat.split(sb);

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            str.append(wordsArray[indexArray[i]]).append(" ");
        }
        return str.toString();
    }
}