package by.it.skarpovich.calc;

import by.it.skarpovich.calc.res.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.read();
        Scanner scanner = new Scanner(System.in);
        String input;

        ResMan resMan = ResMan.INSTANCE;
        if (args.length >= 2) {
            resMan.setLocale(new Locale(args[0], args[1]));
        }
        //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // String s = bf.readLine();

        Locale locale;
        while (!(input = scanner.next()).equals("END")) {
            try {
                if (input.equals("be")) {
                    locale = new Locale("be", "BY");
                    resMan.setLocale(locale);

                } else if (input.equals("ru")) {
                    locale = new Locale("ru", "RU");
                    resMan.setLocale(locale);

                } else if (input.equals("en")) {
                    locale = new Locale("en", "US");
                    resMan.setLocale(locale);
                } else {
                String res = parser.calc(input);
                printer.print(res);
                    System.out.println(resMan.get(Messages.STR_TESTERROR));
                }
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
        Var.save();
    }
}
