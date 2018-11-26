package by.it.nickgrudnitsky.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        String[] string = getStrings(sb);
        sort(string);
        for (String s : string) {
            System.out.println(s);
        }
    }

    private static void sort(String[] string) {
        for (int i1 = 0; i1 < string.length; i1++) {
            for (int i2 = 1; i2 < string.length; i2++) {
                if(string[i2].length()<string[i2-1].length()){
                    String buf = string[i2];
                    string[i2] = string[i2-1];
                    string[i2-1] = buf;
                }
            }
        }
    }

    private static String[] getStrings(StringBuilder sb) {
        String[] string = new String[0];
        Pattern pattern = Pattern.compile("[А-ЯЁ](\\.\\.\\.|[^.!?])*[.!?]");
        Matcher matcher = pattern.matcher(sb);
        int i=0;
        while (matcher.find()){
            int last = string.length;
            string = Arrays.copyOf(string, last+1);
            string[i] = matcher.group();
            i++;
        }
        for (int i1 = 0; i1 < string.length; i1++) {
            Pattern pattern1 = Pattern.compile("[,.:! \\n-]+");
            Matcher matcher1 = pattern1.matcher(string[i1]);
            while (matcher1.find()) {
                string[i1]=matcher1.replaceAll(" ");
            }
        }
        for (int i1 = 0; i1 < string.length; i1++) {
            string[i1] = string[i1].trim();
        }
        return string;
    }
}
