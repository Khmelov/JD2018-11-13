package by.it.naumenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] masWords = new String[0];
    private static int[] masCount = new int[0];

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            serch(word);
        }
        for (int i = 0; i < masWords.length; i++) {
            System.out.println(masWords[i]+"="+masCount[i]);
        }
    }

    static void serch(String word){
        for (int i = 0; i < masWords.length; i++) {
            if(word.equals(masWords[i])){
                masCount[i]++;
                return;
            }
        }
        String[] words=new String[masWords.length+1];
        int[] count = new int[masCount.length+1];
        System.arraycopy(masWords,0,words,0,masWords.length);
        System.arraycopy(masCount,0,count,0,masCount.length);
        masWords=words;
        masWords[masWords.length-1]=word;
        masCount=count;
        masCount[masCount.length-1]=1;
    }

}
