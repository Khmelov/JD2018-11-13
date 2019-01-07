package by.it.denisova.jd02_05;


import java.util.Scanner;
import java.util.Locale;
public class Runner {

    public static void main(String[] args) {
        PrintResult printResult = new PrintResult();
        Scanner scanner = new Scanner(System.in);
        String lang = scanner.next();
        switch (lang) {
            case "ru":
                printResult.changeLocale("ru", "RU");
                ResMan.INSTANCE.setLocale(new Locale("ru", "RU"));
                printResult.print();
                break;
            case "be":
                printResult.changeLocale("be", "BY");
                ResMan.INSTANCE.setLocale(new Locale("be", "BY"));
                printResult.print();
                break;
            case "en":
                printResult.changeLocale("en", "US");
              //  ResMan.INSTANCE.setLocale(new Locale("by.it.denisova.jd02_05.res","US"));
                printResult.print();
                break;
            default:
                System.out.println("Язык не найден");
        }
    }
}