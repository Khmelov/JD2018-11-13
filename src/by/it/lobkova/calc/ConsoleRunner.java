package by.it.lobkova.calc;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws ExceptionCalc {
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (!(input = scanner.nextLine()).equals("end")) {
            Var result = parcer.calcs(input);
            printer.print(result);
        }
    }
}
