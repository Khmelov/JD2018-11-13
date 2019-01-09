package by.it._examples_.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nSample01 {
        public static void main(String[ ] args) {
            for (Integer j = 0; j < 3; j++) {
                char i = j.toString().charAt(0);
                String country = "";
                String language = "";
                switch (i) {
                    case '1':
                        country = "US";
                        language = "EN";
                        System.out.println("\n"+i+" — английский");

                        break;
                    case '2':
                        country = "BY";
                        language = "BE";
                        System.out.println("\n"+i+" — белорусский");
                        break;
                    default:
                        System.out.println("\n"+i+" — русский ");

                }
                Locale current = new Locale(language, country);
                ResourceBundle rb = ResourceBundle.getBundle("by.it._examples_.jd02_05.ok.str",current);
                String s1 = rb.getString("str1");
                System.out.println(s1);
                String s2 = rb.getString("str2");
                System.out.println(s2);
            }
        }
}
