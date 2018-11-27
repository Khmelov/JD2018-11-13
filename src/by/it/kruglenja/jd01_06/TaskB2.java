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
        matcher.reset();
        String[] lines = new String[len];
        int count = 0;
        while (matcher.find()) {
            lines[count] = matcher.group();
            count++;
        }
        matcher.reset();
        boolean flag = false;

        while (!flag) {
            flag = true;
            for (int i = 0; i < lines.length - 1; i++) {
                String temp = " ";
                if (lines[i].length() > lines[i + 1].length()) {
                    temp = lines[i];
                    lines[i] = lines[i + 1];
                    lines[i + 1] = temp;
                    flag = false;
                }
            }
        }
        StringBuilder sortedLines = new StringBuilder();
        for (int i = 0; i < len; i++) {
            System.out.print(lines[i]);
        }
    }
}
