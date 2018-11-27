package by.it.kruglenja.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);

        Pattern symbolRemove = Pattern.compile("[А-ЯЁ](\\.\\.\\.|[^.!?])*[.!?]");
        Matcher matcher = symbolRemove.matcher(sb);
        int len = 0;
        while (matcher.find()) {
            len++;
        }
        String[]newArr = new String[len];        
        int count = 0;
        while (matcher.find()) {
            newArr[count] = matcher.group();
            count++;
        }
        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int i = 0; i < newArr.length - 1; i++) {
                String temp = "";
                if (newArr[i].length() > newArr[i + 1].length()) {
                    temp = newArr[i];
                    newArr[i] = newArr[i + 1];
                    newArr[i + 1] = temp;
                    flag = false;
                }
            }

            }System.out.println("_________________________________________");
        for (String anewArr : newArr) {
            System.out.println(anewArr);
        }
//        Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ]*");
//        Matcher matcher = pattern.matcher(sb);
//        while (matcher.find()){
//            System.out.println(matcher.group());
//
//            int x = matcher.start();
//            System.out.println(sb.charAt(x));
//            sb.deleteCharAt(x);
//
//        }
//        System.out.println(sb.toString());
    }
}
