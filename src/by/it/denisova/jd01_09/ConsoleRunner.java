package by.it.denisova.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Parcer pars = new Parcer();
        Printer printer = new Printer();
        Scanner scanner= new Scanner(System.in);
        String line;




        while (!(line = scanner.next()).equals("END")){
            Var result = pars.calc(line);
            printer.print(result);
        }
    }

}