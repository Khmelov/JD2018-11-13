package by.it.karnilava.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

class SwitchLanguages {

    public SwitchLanguages(String line) {


        String country;
        String language;

        switch (line) {

            case "ru":
                country = "RU";
                language = "ru";
                System.out.println("\n" + line + " - русский");
                break;

            case "be":
                country = "BY";
                language = "be";
                System.out.println("\n" + line + " - беларуская");
                break;

            default:
                country = "EN";
                language = "en";
                System.out.println("\n" + line + " - english");


        }


        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("by.it.karnilava.jd02_05.MessageBundleGreeting", current);
        String s = rb.getString("greetings");
        System.out.println(s);
        String s1 = rb.getString("name");
        System.out.println(s1);
        String s2 = rb.getString("languageChoice");
        System.out.println(s2);
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, current);
        String date = df.format(new Date());
        System.out.println(date);
        String s3 = rb.getString("end");
        System.out.println(s3);
    }
}


