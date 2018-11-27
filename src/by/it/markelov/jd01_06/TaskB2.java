package by.it.markelov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("[\\.!]+");
        String[] s = pat.split(Poem.text);
        StringBuilder[] sb = new StringBuilder[s.length];
        for (int i = 0; i < s.length; i++) {
            sb[i] = new StringBuilder(s[i]);
            // System.out.println(sb[i]);

        }
        pat = Pattern.compile("[,-:]");
        Matcher mat;
        for (int i = 0; i < sb.length; i++) {
            mat = pat.matcher(sb[i]);
            while (mat.find()) {
                sb[i].setCharAt(mat.start(), ' ');
//                sb[i].trimToSize();
            }
           // System.out.println(sb[i]);
        }

        pat = Pattern.compile(" {2,}");
        for (int i = 0; i < sb.length; i++) {
            mat = pat.matcher(sb[i]);
            while (mat.find()) {
                //sb[i].delete(mat.start() + 1, mat.end()+1);
            }
            System.out.println(sb[i]);
//

        }
    }
}





