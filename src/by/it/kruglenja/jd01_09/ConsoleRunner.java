package by.it.kruglenja.jd01_09;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleRunner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = "";

        Parser parser = new Parser();
        Patterns patterns = new Patterns();

        while ((line = sc.nextLine()).equals("END")){
            Var res = Parser.calc(line);
            System.out.println(res);
        }
    }
}
