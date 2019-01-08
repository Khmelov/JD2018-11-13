package by.it.berdnik.jd02_05;


import by.it.berdnik.jd02_05.res.Messages;

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

        System.out.printf("Enter language: ");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String string = bf.readLine();
        Locale locale;
        if (string.equals("be")) {
            locale = new Locale("be", "BY");
            resMan.setLocale(locale);
        } else if (string.equals("ru")) {
            locale = new Locale("ru", "RU");
            resMan.setLocale(locale);
        } else if (string.equals("en")) {
            locale = new Locale("en", "US");
            resMan.setLocale(locale);
        }

        Date now = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, resMan.getLocale());

        System.out.println(df.format(now));
        System.out.println(resMan.get(Messages.STR_WELCOME));
        System.out.println(resMan.get(Messages.STR_QUESTION));
        System.out.println(resMan.get(Messages.USER_NAME));
    }
}
