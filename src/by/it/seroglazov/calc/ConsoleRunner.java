package by.it.seroglazov.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.next()).toUpperCase().equals("END")) {
            if (input.equalsIgnoreCase("printvar")) {
                System.out.println(Var.getVars());
            } else if (input.equalsIgnoreCase("sortvar")) {
                System.out.println(Var.getVars());
            } else {
                Var res = parcer.calc(input);
                printer.print(res);
            }
        }

    }
}
