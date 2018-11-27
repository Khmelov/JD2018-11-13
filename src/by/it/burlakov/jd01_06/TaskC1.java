package by.it.burlakov.jd01_06;

import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
      StringBuilder sb = new StringBuilder(Poem.text);
        Pattern patt = Pattern.compile("\\n");
        String[] strings = patt.split(sb);
        int lenMax = getMax(strings);

        for (String str: strings){
            System.out.println(addSpace(str, lenMax));
        }

    }

    private static String addSpace(String str, int lenMax){
        int lenStr = 0;
        String[] words = wordsSplit(str);
        for (String string: words){
           lenStr += string.length();
        }
        int delta = lenMax - lenStr;
        int lenWords = words.length;
        int countSpace = delta / (lenWords - 1);
        int extraSpace = delta % (lenWords - 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
            if(i != words.length - 1){
                for (int j = 0; j < countSpace; j++) {
                    result.append(" ");
                }
                if(extraSpace > 0){
                    result.append(" ");
                    extraSpace--;
                }
            }
        }
        return result.toString();
    }

    private static int getMax(String[] str){
        int lenMax = str[0].length();
        for (int i = 0; i < str.length; i++) {
            if(str[i].length() > lenMax){
                lenMax = str[i].length();
            }

        }
        return lenMax;
    }
    private static String[] wordsSplit(String str){
        String[] result = str.split(" ");
        return result;
    }
}
