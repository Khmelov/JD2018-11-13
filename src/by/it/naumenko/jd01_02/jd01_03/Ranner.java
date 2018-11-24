package by.it.naumenko.jd01_02.jd01_03;

import java.util.Scanner;

/**
 * Created by user on 17.11.2018.
 */
public class Ranner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr);
        InOut.printArray(arr,"T",3);
    }
}
