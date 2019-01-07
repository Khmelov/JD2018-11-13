package by.it.markelov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResourceBundle resourceBundle;
        Date date = new Date();
        DateFormat dateFormat;
        String dateToString = null;
        Locale locale;

        if (args.length >= 2) {
            locale = new Locale(args[0], args[1]);
            resourceBundle = ResourceBundle.getBundle("by.it.markelov.jd02_05.MyResources", locale);
            dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
            dateToString = dateFormat.format(date);
        } else {
            Locale.setDefault(new Locale("en", "EN"));
            resourceBundle = ResourceBundle.getBundle("by.it.markelov.jd02_05.MyResources", Locale.getDefault());
            dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
            dateToString = dateFormat.format(date);
        }

        System.out.println(resourceBundle.getString(Fields.getWELCOME()));
        System.out.println(resourceBundle.getString(Fields.getINTRODUCE()));
        System.out.println(resourceBundle.getString(Fields.getNAME()));
        System.out.println(resourceBundle.getString(Fields.getDATE()) + " " + dateToString);

        if (args.length != 0) {
            if (args[0].equals("ru")) System.out.println(Info.getInfoRu1());
            else if (args[0].equals("be")) System.out.println(Info.getInfoBe1());
            else System.out.println(Info.getInfoEn1());
        } else System.out.println(Info.getInfoEn1());

        Scanner scanner = new Scanner(System.in);
        String language;
        while (!(language = scanner.next()).equals("END")) {
            switch (language) {
                case "ru": {
                    locale = new Locale("ru", "RU");
                    resourceBundle = ResourceBundle.getBundle("by.it.markelov.jd02_05.MyResources", locale);
                    dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
                    dateToString = dateFormat.format(date);
                    break;
                }
                case "be": {
                    locale = new Locale("be", "BY");
                    resourceBundle = ResourceBundle.getBundle("by.it.markelov.jd02_05.MyResources", locale);
                    dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
                    dateToString = dateFormat.format(date);
                    break;
                }
                case "en": {
                    locale = new Locale("en", "EN");
                    resourceBundle = ResourceBundle.getBundle("by.it.markelov.jd02_05.MyResources", locale);
                    dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
                    dateToString = dateFormat.format(date);
                    break;
                }
                default: {
                    Locale.setDefault(new Locale("en", "EN"));
                    resourceBundle = ResourceBundle.getBundle("by.it.markelov.jd02_05.MyResources", Locale.getDefault());
                    dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
                    dateToString = dateFormat.format(date);
                }
            }
            System.out.println(resourceBundle.getString(Fields.getWELCOME()));
            System.out.println(resourceBundle.getString(Fields.getINTRODUCE()));
            System.out.println(resourceBundle.getString(Fields.getNAME()));
            System.out.println(resourceBundle.getString(Fields.getDATE()) + " " + dateToString);
            if (!language.equals("en") && !language.equals("ru") && !language.equals("be")) {
                if (args.length != 0) {
                    if (args[0].equals("ru")) System.out.println(Info.getInfoRu2());
                    else if (args[0].equals("be")) System.out.println(Info.getInfoBe2());
                    else System.out.println(Info.getInfoEn2());
                } else System.out.println(Info.getInfoEn2());
            }
        }
    }
}


