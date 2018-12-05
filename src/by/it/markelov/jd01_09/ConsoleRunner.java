package by.it.markelov.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scr.nextLine()).equals("end")) {
            Var result = parser.culc(line);
            printer.print(result);
        }
    }
}
