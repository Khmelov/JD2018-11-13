package by.it.skarpovich.jd02_05;

import by.it.skarpovich.jd02_05.res.Messages;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) throws IOException {

        ResMan resMan = ResMan.INSTANCE;
        if (args.length >= 2) {
            resMan.setLocale(new Locale(args[0], args[1]));
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        Locale locale;
        if (s.equals("be")) {
            locale = new Locale("be", "BY");
            resMan.setLocale(locale);
        } else if (s.equals("pl")) {
            locale = new Locale("pl", "PL");
            resMan.setLocale(locale);
        } else if (s.equals("ru")) {
            locale = new Locale("ru", "RU");
            resMan.setLocale(locale);
        } else if (s.equals("en")) {
            locale = new Locale("en", "US");
            resMan.setLocale(locale);
        }

        System.out.println(resMan.get(Messages.STR_HELLO));
        System.out.println(resMan.get(Messages.STR_QUESTION));
        System.out.println(resMan.get(Messages.STR_NAME));

        Date d = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, resMan.getLocale());
        System.out.println(dateFormat.format(d));
    }
}