package by.it.berdnik.jd01_09;

import by.it.berdnik.jd01_09.Printer;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        by.it.berdnik.jd01_09.Parcer parcer=new by.it.berdnik.jd01_09.Parcer();
        Printer printer=new Printer();
        Scanner scanner=new Scanner(System.in);
        String input;
        while (!(input=scanner.next()).equals("END")){
            by.it.berdnik.jd01_09.Var res = parcer.calc(input);
            printer.print(res);
        }

    }
}
