package by.it.baidak.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Parser parcer=new Parser();
        Printer printer=new Printer();
        Scanner scanner=new Scanner(System.in);
        String input;
        while (!(input=scanner.next()).equals("END")){
            Var res = parcer.calc(input);
            printer.print(res);
        }
    }
}
