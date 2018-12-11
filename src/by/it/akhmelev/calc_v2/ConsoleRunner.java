package by.it.akhmelev.calc_v2;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Parcer parcer=new Parcer();
        Printer printer=new Printer();
        Scanner scanner=new Scanner(System.in);
        String input;
        while (!(input=scanner.next()).equals("END")){
            try {
                Var res = parcer.calc(input);
                printer.print(res);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
