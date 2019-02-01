package by.it.mnovikov.jd02_05;

import by.it.mnovikov.jd02_05.res.Messages;

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

        Locale locale;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strloc = br.readLine();

        switch (strloc) {
            case "ru":
                locale = new Locale("ru", "RU");
                resMan.setLocale(locale);
                break;
            case "be":
                locale = new Locale("be", "BY");
                resMan.setLocale(locale);
                break;
            case "en":
                locale = new Locale("en", "US");
                resMan.setLocale(locale);
                break;
        }

        System.out.println(resMan.get(Messages.STR_WELCOME));
        System.out.println(resMan.get(Messages.STR_QUESTION));
        System.out.println(resMan.get(Messages.USER_NAME));

        Date currentdate = new Date();
        DateFormat dF = DateFormat.getDateInstance(DateFormat.FULL, resMan.getLocale());
        System.out.println(dF.format(currentdate));

    }
}
