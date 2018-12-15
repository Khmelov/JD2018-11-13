package by.it.karnilava.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scan.nextLine()).equals("end")) {
            if (line.equals("printvar")) {

                for (Map.Entry<String, Var> entry : Var.vars.entrySet()) {
                    System.out.println(entry.getKey() + "=" + entry.getValue());
                }
            }

            try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}

