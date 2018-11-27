package by.it.markelov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder(Poem.text);
        System.out.println(s + "\n");

        Pattern pat = Pattern.compile("[[А-Я]Ё[а-я]ё]+");
        Matcher mat = pat.matcher(s);
        int count = 0;
        while (mat.find()) {
            count++;
        }
        mat.reset();

        String[] mas1 = new String[count];
        String[] mas2 = new String[count];
        int [] repeat=new int[count];

        for (int i = 0; i < mas1.length; i++) {
            mat.find();
            mas1[i] = mat.group();
            System.out.println(mas1[i]);
        }
        System.out.println("\n");

        System.arraycopy(mas1,0, mas2,0, mas2.length);
        for (String s1 : mas2) {
            System.out.println(s1);

        }

        for (int i = 0; i < mas1.length; i++) {
            for (int j = 0; j < mas2.length; j++) {
                if (mas1[i].equals(mas2[j])) {
                    repeat[i]++;
                }
            }
            System.out.println(mas1[i]+"="+repeat[i]);

        }




    }


}

