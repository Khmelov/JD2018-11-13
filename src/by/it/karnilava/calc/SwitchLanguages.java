package by.it.karnilava.calc;


import java.util.Locale;
import java.util.ResourceBundle;

class SwitchLanguages {

    static  ResourceBundle rb = ResourceBundle.getBundle("by.it.karnilava.calc.MessagesList", Locale.getDefault());
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
        rb = ResourceBundle.getBundle("by.it.karnilava.calc.MessagesList", current);
//        String s = rb.getString("greetings");
//        System.out.println(s);

    }
}


