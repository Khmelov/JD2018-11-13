package by.it.naumenko.Calculator;


import by.it.naumenko.Calculator.resourse.ResourceManager;
import by.it.naumenko.Calculator.resourse.TextTranslate;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException, CalcExeption {
        ResourceManager resVar = ResourceManager.INSTANCE;
        if (args.length>=2) {
            Locale locale = new Locale(args[0], args[1]);
            resVar.setLocale(locale);
        }
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        Var.readVarFile();
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println(resVar.get(TextTranslate.END));
        while (!(input=scanner.next()).equals(resVar.get(TextTranslate.EXIT))){
            //String rechenie = null;
            try {
                String rechenie = parcer.calc(input);
                printer.print(rechenie);
            } catch (CalcExeption calcExeption) {
                System.out.println(calcExeption.getMessage());
            }
            Var.save();
            //

        }
    }
}
