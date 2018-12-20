package by.it.naumenko.Calculator;



import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input=scanner.next()).equals("end")){
            Var rechenie = null;
            try {
                rechenie = parcer.calc(input);
                printer.print(rechenie);
            } catch (CalcExeption calcExeption) {
                System.out.println(calcExeption.getMessage());
            }
            //

        }
    }
}
