package by.it.akhmelev.jd01_09;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Parcer parcer=new Parcer();
        Printer printer=new Printer();
        Scanner scanner=new Scanner(System.in);
        String input;
        while (!(input=scanner.next()).equals("END")){
            Var res = parcer.calc(input);
            printer.print(res);
        }

    }
}
