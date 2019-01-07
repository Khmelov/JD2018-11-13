package by.it.naumenko.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Date nowData = new Date();

        ResourceManager resVar = ResourceManager.INSTANCE;
        Locale locale = new Locale(args[0],args[1]);
        resVar.setLocale(locale);
        System.out.println(resVar.get(TextTranslate.STR_WELCOME));
        System.out.println(resVar.get(TextTranslate.STR_QUESTION));
        System.out.println(resVar.get(TextTranslate.NAME));
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL,locale);
        System.out.println(dateFormat.format((nowData)));
    }
}
