package by.it.mnovikov.jd01_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 01.12.2018.
 */
public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Parcer parser = new Parcer();
        Printer printer = new Printer();

        while (!(line = br.readLine()).equals("end")){
            Var result = parser.calc(line);
            printer.print(result);
        }

    }
}
