package by.it.naumenko.jd01_02.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    static int maxWord(StringBuilder[] mas){
        int max=mas[0].length();
        for (int i = 0; i < mas.length; i++) {
            if(mas[i].length()>max)
                max = mas[i].length();
        }
        return max;
    }
    public static void main(String[] args) {
        String text = new String(Poem.text);
        String[] wordArray = text.split("\\n");
        StringBuilder[] sbArray = new StringBuilder[wordArray.length];

        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i].length() != 0) {
                sbArray[i] = new StringBuilder(wordArray[i]);
            }
        }
        for (int i = 0; i < sbArray.length; i++) {
            System.out.printf("%s  %d\n",sbArray[i],sbArray[i].length());
        }
        int maxWord=maxWord(sbArray);
        System.out.println(maxWord);

        Pattern pattern = Pattern.compile("[^А-Яа-яёЁ]");
        for (StringBuilder v : sbArray) {
            Matcher matcher = pattern.matcher(v);
            //int r = maxWord - v.length();
            while (matcher.find()){
                while (v.length() < maxWord) {
                    int position = matcher.start();
                    v.insert(position, ' ');
                    //v.setCharAt(position,'@');
                }
            }

        }

        System.out.println("=================ровный==========================");
        for (int i = 0; i < sbArray.length; i++) {
            System.out.printf("%s  %d\n",sbArray[i],sbArray[i].length());
        }
    }
}
