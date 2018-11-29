package by.it.berdnik.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB2 {
    static String[] sens;
    public static void main(String[] args) {
        String text = Poem.text.replaceAll("\n+", " ");
        Pattern p = Pattern.compile("[А-ЯЁ](\\.\\.\\.|[^.!?])*[.!?]");
        Matcher m = p.matcher(text);
        int count = 0;
        while (m.find()) count++;
        sens = new String[count];
        m.reset();
        int i = 0;
        while (m.find()) sens[i++] = m.group().replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        sortStringArray(sens);
        for (String sen : sens) {
            System.out.println(sen);
        }
    }
            private static void sortStringArray(String[] sens) {
                int[] lens = new int[sens.length];
                for (int i = 0; i < sens.length; i++) {
                    lens[i] = sens[i].length();
                }
                String[] out = new String[sens.length];
                Arrays.sort(lens);
                    for (String sen : sens) {
                        for (int i = 0; i < lens.length; i++) {
                            if (sen.length() == lens[i] && out[i] == null){
                                out[i] = sen;
                                break;
                            }
                        }
                    }
                    System.arraycopy(out, 0, sens, 0, out.length);
                }
            }