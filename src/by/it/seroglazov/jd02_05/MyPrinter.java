package by.it.seroglazov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class MyPrinter {

    private MyPrinter(){
    }

    private static Locale locale = Locale.ENGLISH;
    private static final int myDateFormat = DateFormat.LONG;
    private static DateFormat dateFormat = DateFormat.getDateTimeInstance(myDateFormat, myDateFormat, locale);

    static void changeLanguage(Locale locale) {
        MyPrinter.locale = locale;
        TextRes.changeLanguage(locale);
        dateFormat = DateFormat.getDateTimeInstance(myDateFormat, myDateFormat, locale);
        System.out.println(TextRes.get(TextRes.text.LANGUAGE_CHANGED));
    }

    static void printHelloWords(){
        System.out.println(TextRes.get(TextRes.text.WELCOME));
        System.out.println(TextRes.get(TextRes.text.HOW_DO_YOU_DO));
    }

    static void printUserName(){
        System.out.println(TextRes.get(TextRes.user.NAME));
    }

    static void printUnknownCommand(){
        System.out.println(TextRes.get(TextRes.text.UNKNOWN_COMMAND));
    }

    static void printDateTime(){
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
