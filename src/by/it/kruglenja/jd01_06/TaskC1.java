package by.it.kruglenja.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
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
        for (int i = 0; i < separatedLines.length; i++) {
            System.out.println(separatedLines[i]);
        }
    }
}
