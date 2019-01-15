package by.it.markelov.jd02_06.Calculator;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException, CalcException {
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.readVarFile();
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.next()).equals("end")) {
            String result = null;
            try {
                result = parser.calc(input);
                printer.print(result);
            } catch (CalcException calcException) {
                System.out.println(calcException.getMessage());
            }
            Var.save();
        }
    }
}
