package by.it.kruglenja.jd02_05;


import by.it.akhmelev.jd02_05.res.Messages;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose language: be, ru, en or end to exit");
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("end"))
                break;
            switch (s) {
                case "be":
                    resMan.setLocale(new Locale("be", "BY"));
                    break;
                case "en":
                    resMan.setLocale(new Locale("", ""));
                    break;
                case "ru":
                    resMan.setLocale(new Locale("ru", "RU"));
            }

            System.out.println(resMan.getDate());
            System.out.println(resMan.get(Messages.STR_WELCOME));
            System.out.println(resMan.get(Messages.STR_QUESTION));
            System.out.println(resMan.get(Messages.USER_NAME));
        }
    }
}
