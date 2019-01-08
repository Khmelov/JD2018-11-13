package by.it.naumenko.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResourceManager resVar = ResourceManager.INSTANCE;
        Locale locale = new Locale(args[0],args[1]);
        resVar.setLocale(locale);
        System.out.println(resVar.get(TextTranslate.STR_WELCOME));
        System.out.println(resVar.get(TextTranslate.STR_QUESTION));
        System.out.println(resVar.get(TextTranslate.NAME));
    }
}
