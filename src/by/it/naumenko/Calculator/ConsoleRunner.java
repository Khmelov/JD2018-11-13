package by.it.naumenko.Calculator;

import by.it.naumenko.Calculator.resourse.ResourceManager;
import by.it.naumenko.Calculator.resourse.TextTranslate;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException, CalcExeption {

        ResourceManager resVar = ResourceManager.INSTANCE;
        String userLocal=Locale.getDefault().toString();
        Locale locale;
        Scanner scanner = new Scanner(System.in);
        System.out.println(resVar.get(TextTranslate.LOCALE));
        userLocal = scanner.next();
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
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        Var.readVarFile();
        String input;
        System.out.println(resVar.get(TextTranslate.END));

        while (!(input=scanner.next()).equals(resVar.get(TextTranslate.EXIT))){
            try {
                String rechenie = parcer.calc(input);
                printer.print(rechenie);
            } catch (CalcExeption calcExeption) {
                System.out.println(calcExeption.getMessage());
            }
            Var.save();
        }
    }
}
