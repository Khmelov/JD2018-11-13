package by.it.baidak.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {

        Parser parcer=new Parser();
        Printer printer=new Printer();
        Var.read();

        Scanner scanner=new Scanner(System.in);
        String input;

        while (!(input=scanner.next()).equals("END")){
            String res = parcer.calc(input);
            printer.print(res);
        }
        Var.save();
    }
}
