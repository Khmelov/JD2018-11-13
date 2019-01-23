package by.it.evenchik.jd02_05;

import by.it.evenchik.jd02_05.res.Messages;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResManager resManager = ResManager.INSTANCE;
        String line;
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, new Locale("en", "EN"));
        Date date = new Date();


        if (args.length >=2) {
            resManager.setLocale(new Locale(args[0], args[1]));
            dateFormat = changeLocale(new Locale(args[0], args[1]));
        }
        print(resManager, dateFormat, date);


        while (!(line=scanner.nextLine()).equalsIgnoreCase("end")){
            if (line.equalsIgnoreCase("ru")){
                resManager.setLocale(new Locale("ru", "RU"));
                dateFormat = changeLocale(new Locale("ru", "RU"));
            }
            if (line.equalsIgnoreCase("be")){
                resManager.setLocale(new Locale("be", "BY"));
                dateFormat = changeLocale(new Locale("be", "BY"));
            }
            if (line.equalsIgnoreCase("en")){
                resManager.setLocale(new Locale("en", "EN"));
                dateFormat = changeLocale(new Locale("en", "EN"));
            }
            print(resManager, dateFormat, date);
        }
    }

    private static DateFormat changeLocale(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        return dateFormat;
    }

    private static void print(ResManager resManager, DateFormat dateFormat, Date date) {
        System.out.println(resManager.get(Messages.STR_WELCOME));
        System.out.println(resManager.get(Messages.STR_QUESTION));
        System.out.println(resManager.get(Messages.USER_NAME));
        System.out.println(dateFormat.format(date));
    }
}
