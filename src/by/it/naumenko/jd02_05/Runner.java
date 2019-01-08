package by.it.naumenko.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Date nowData = new Date();
        ResourceManager resVar = ResourceManager.INSTANCE;
        String userLocal = Locale.getDefault().toString();
        Locale locale;
        while (!(userLocal.equals(resVar.get(TextTranslate.EXIT)))) {

            switch (userLocal) {
                case "en":
                    locale = new Locale("en", "EN");
                    break;
                case "ru":
                    locale = new Locale("ru", "RU");
                    break;
                case "be":
                    locale = new Locale("be", "BY");
                    break;
                default:
                    locale = Locale.getDefault();
                    break;
            }
            resVar.setLocale(locale);

            System.out.println(resVar.get(TextTranslate.STR_WELCOME));
            System.out.println(resVar.get(TextTranslate.STR_QUESTION));
            System.out.println(resVar.get(TextTranslate.NAME));
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
            System.out.println(dateFormat.format((nowData)));
            System.out.println("-----------------------------");
            System.out.println(resVar.get(TextTranslate.LOCALE));
            userLocal = scanner.nextLine();
        }


    }
}
