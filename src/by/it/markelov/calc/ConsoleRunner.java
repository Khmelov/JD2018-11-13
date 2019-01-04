package by.it.markelov.calc;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException, CalcExeption {
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        Var.readVarFile();
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.next()).equals("end")) {
            Var result = null;
            try {
                result = parcer.calc(input);
                printer.print(result);
            } catch (CalcExeption calcExeption) {
                System.out.println(calcExeption.getMessage());
            }
            Var.save();
        }
    }
}
