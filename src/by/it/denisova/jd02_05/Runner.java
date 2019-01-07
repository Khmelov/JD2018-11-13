package by.it.denisova.jd02_05;


import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        PrintResult printResult = new PrintResult();
        Scanner scanner = new Scanner(System.in);
        String lang = scanner.next();
        switch (lang) {
            case "ru":
                printResult.changeLocale("ru", "RU");
                printResult.Print();
                break;
            case "be":
                printResult.changeLocale("be", "BY");
                printResult.Print();
                break;
            case "en":
                printResult.changeLocale("eng", "US");
                printResult.Print();
                break;
            default:
                System.out.println("Язык не найден");
        }
    }
}