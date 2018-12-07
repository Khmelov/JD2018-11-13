package by.it.burlakov.jd01_09;

import java.util.Scanner;


public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = scanner.nextLine().toLowerCase()).equals("end")){
            Var var = parser.calc(line);
            printer.print(var);
        }
    }
}
