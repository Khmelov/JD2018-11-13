package by.it._examples_.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Class04_Scanner {
    public static void main(String[ ] args) throws FileNotFoundException {
        double sum = 0.0;
        String src=System.getProperty("user.dir")+"/src/by/it/_examples_/jd01_14/";
        String filename = src+"scan.txt";
        File f=new File(filename);
        Scanner scan = new Scanner(f);

        scan.useLocale(Locale.FRANCE);  //числа через запятую
        // scan.useLocale(Locale.US);
        scan.useDelimiter(";\\s*");     //разделитель точка с запятой
                                        // и возможно пробел(ы)
        while (scan.hasNext()) {        //пока есть следующие пробелы
            if (scan.hasNextDouble()) {
                sum += scan.nextDouble();
            } else {
                System.out.println(scan.next());
            }
        }
        scan.close();
        System.out.printf("Сумма чисел = " + sum);
    }
}
