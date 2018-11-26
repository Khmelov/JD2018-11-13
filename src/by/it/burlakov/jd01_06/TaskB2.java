package by.it.burlakov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern patt = Pattern.compile("([.]{2,})");
        Matcher matcher = patt.matcher(Poem.text);
        while (matcher.find()){
//            System.out.println(matcher.group());
            sb.replace(matcher.start(), matcher.end(), " ");
        }
//        System.out.println(sb);

        Pattern pattern = Pattern.compile("([.!?])");

        String[] sentencesArray = pattern.split(sb);
        String[][] resultArrays = new String[sentencesArray.length][1];

        for (int i = 0; i < sentencesArray.length; i++) {
            resultArrays[i] = trimAndReplace(sentencesArray[i]);
        }
        printArray(sortArrays(resultArrays));
    }

    private static String[] trimAndReplace(String str){
        String[] result = new String[1];
        str = str.replaceAll("[\\n,:!-]", " ");
        result[0] = str.replaceAll("[\\s]+", " ").trim();

        return result;
    }

    private static String[][] sortArrays(String[][] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j][0].length() != 0) {
                    if (arr[j][0].length() > arr[j + 1][0].length()) {
                        String temp = arr[j][0];
                        arr[j][0] = arr[j + 1][0];
                        arr[j + 1][0] = temp;
                    }
                }
            }
        }
        return arr;
    }

    private static void printArray(String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}