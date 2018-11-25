package by.it.seroglazov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    static String[] sens;

    public static void main(String[] args) {
        String text = Poem.text.replaceAll("\n", " ");
        Pattern p = Pattern.compile("[А-ЯЁ](\\.\\.\\.|[^.!?])*[.!?]");
        Matcher m = p.matcher(text);
        int count = 0; // Number of sentences
        while (m.find()) count++;
        sens = new String[count];
        m.reset();
        int i = 0;
        while (m.find()) sens[i++] = m.group();
        // Now we have an array 'sens' that contains all sentences of the text
        sortStringArray(sens);
        for (String sen : sens) {
            System.out.println(sen);
        }
    }

    private static void sortStringArray(String[] sents) {
        int[] lens = new int[sents.length]; // How many letters in sentences
        for (int i = 0; i < sents.length; i++) {
            lens[i] = sents[i].length();
        }
        String[] out = new String[sents.length];
        Arrays.sort(lens);
        for (String sen : sents) {
            for (int i = 0; i < lens.length; i++) {
                if (sen.length() == lens[i] && out[i] == null){
                    out[i] = sen;
                }
            }
        }
        sents = out;
        sents[0] = "TEST";
    }

}


























