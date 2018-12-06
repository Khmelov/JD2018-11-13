package by.it.denisova.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String line;

        Parcer pars = new Parcer();
        Printer printer = new Printer();

        while (!(line = scanner.nextLine()).equals("end")){
            Var result = pars.calc(line);
            printer.print(result);
        }
    }

}