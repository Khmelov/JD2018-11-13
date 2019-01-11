package by.it.nickgrudnitsky.calc;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line;
        ResManager resManager = ResManager.INSTANCE;
        Parcer parser = new Parcer();
        Printer printer = new Printer();

        Var.read();
        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.equals("printvar")) {
                Var.printVar();
                continue;
            }
            if (line.equals("sortvar")) {
                Var.sortVar();
                continue;
            }
            Var result;
            try {
                result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
            if (line.equalsIgnoreCase("ru")){
                resManager.setLocale(new Locale("ru", "RU"));
            }
            if (line.equalsIgnoreCase("be")){
                resManager.setLocale(new Locale("be", "BY"));
            }
            if (line.equalsIgnoreCase("en")){
                resManager.setLocale(new Locale("en", "EN"));
            }
        }
        Var.saveTo();
    }
}
