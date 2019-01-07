package by.it.seroglazov.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        if (args.length > 1) MyPrinter.changeLanguage(new Locale(args[0], args[1]));
        MyPrinter.printHelloWords();
        MyPrinter.printUserName();
        Scanner sc = new Scanner(System.in);
        MyPrinter.printDateTime();
        while (sc.hasNext()) {
            String command = sc.nextLine();
            switch (command) {
                case "be":
                case "BE":
                    MyPrinter.changeLanguage(new Locale("be", "BY"));
                    break;
                case "ru":
                case "RU":
                    MyPrinter.changeLanguage(new Locale("ru", "RU"));
                    break;
                case "en":
                case "EN":
                    MyPrinter.changeLanguage(Locale.ENGLISH);
                    break;
                case "end":
                case "END":
                    return;
                case "time":
                case "date":
                case "TIME":
                case "DATE":
                    MyPrinter.printDateTime();
                    break;
                default:
                    MyPrinter.printUnknownCommand();
            }
        }
    }
}
