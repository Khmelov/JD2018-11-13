package by.it.seroglazov.jd02_05;

import java.util.Locale;

class MyPrinter {

    private MyPrinter(){
    }

    static void changeLanguage(Locale locale) {
        TextRes.changeLanguage(locale);
    }

    static void printHelloWords(){
        System.out.println(TextRes.get(TextRes.text.WELCOME));
        System.out.println(TextRes.get(TextRes.text.HOW_DO_YOU_DO));
    }

    static void printUserName(){
        System.out.println(TextRes.get(TextRes.user.NAME));
    }
}
