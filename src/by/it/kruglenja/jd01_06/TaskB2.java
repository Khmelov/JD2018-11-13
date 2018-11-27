package by.it.kruglenja.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);

        Pattern lineDivider = Pattern.compile("[А-ЯЁ](\\.\\.\\.|[^.!?])*[.!?]");
        Matcher matcher = lineDivider.matcher(sb);
        int len = 0;
        while (matcher.find()) {
            len++;
        }
        matcher.reset();
        String[] separatedLines = new String[len];
        int count = 0;
        while (matcher.find()) {
            separatedLines[count] = matcher.group();
            count++;
        }
        matcher.reset();
        for (int i = 0; i < separatedLines.length; i++) {
            separatedLines[i] = separatedLines[i].replaceAll("[^А-Яа-яёЁ[^А-Яа-яЁё]]{1,}", " ").trim();
        }
        matcher.reset();
        boolean flag = false;

        while (!flag) {
            flag = true;
            for (int i = 0; i < separatedLines.length - 1; i++) {
                String temp = " ";
                if (separatedLines[i].length() > separatedLines[i + 1].length()) {
                    temp = separatedLines[i];
                    separatedLines[i] = separatedLines[i + 1];
                    separatedLines[i + 1] = temp;
                    flag = false;
                }
            }
        }
        StringBuilder sortedseparatedLines = new StringBuilder();
        for (int i = 0; i < len; i++) {
            System.out.print(separatedLines[i] + '\n');
        }
    }
}
