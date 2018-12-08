package by.it.burlakov.calc;

import java.util.Scanner;


public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = scanner.nextLine().toLowerCase()).equals("end")){
            if(line.equalsIgnoreCase("printvar")){
                Printer.printvar();
                continue;
            }
            if(line.equalsIgnoreCase("sortvar")){
                Printer.sortvar();
                continue;
            }
            Var var = parser.calc(line);
            printer.print(var);
        }
    }
}
