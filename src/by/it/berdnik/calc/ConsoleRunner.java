package by.it.berdnik.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Parcer parcer=new Parcer();
        Printer printer=new Printer();
        Scanner scanner=new Scanner(System.in);
        String input;
        while (!(input=scanner.next()).equals("end")){
            Var res = parcer.calc(input);
            printer.print(res);
        }

    }
}
