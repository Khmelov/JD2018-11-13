package by.it.seroglazov.jd02_05;

import java.util.Locale;

public class Runner {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        if (args.length > 1) MyPrinter.changeLanguage(new Locale(args[0], args[1]));
        MyPrinter.printHelloWords();
        MyPrinter.printUserName();
    }
}
