package by.it.kovalyova.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String line;

        Parser parser=new Parser();
        //Printer printer=new Printer();

        while (!(line = scan.nextLine()).equals("end")) {
            String result = parser.parse(line);
            System.out.println(result);
        }
    }
}
