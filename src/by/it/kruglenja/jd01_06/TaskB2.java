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
        int[] counter = new int[len];
        matcher.reset();
        int c = 0;
        while (matcher.find()) {
            counter[c] = matcher.end() - 1 - matcher.start();
            System.out.println(counter[c]);
            c++;
        }
        int[] printOrder = new int[len];
        System.arraycopy(counter, 0, printOrder, 0, printOrder.length);
        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int i = 0; i < printOrder.length - 1; i++) {
                int temp = 0;
                if (printOrder[i] > printOrder[i + 1]) {
                    temp = printOrder[i];
                    printOrder[i] = printOrder[i + 1];
                    printOrder[i + 1] = temp;
                    flag = false;
                }
            }

            }System.out.println("_________________________________________");
        for (int aPrintOrder : printOrder) {
            System.out.println(aPrintOrder);
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
