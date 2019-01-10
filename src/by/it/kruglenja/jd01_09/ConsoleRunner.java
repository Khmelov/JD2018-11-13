package by.it.kruglenja.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.read();

        while (!(line = sc.nextLine()).equals("end")){
            try {
                Var res = parser.calc(line);
                printer.print(res);
            }catch (CalcExeption e){
                System.out.println(e.getMessage());
            }
        }Var.save();
    }
}
