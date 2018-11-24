package by.it.mnovikov.jd01_03;

import java.util.Scanner;

/**
 * Created by user on 17.11.2018.
 */
public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr);
        InOut.printArray(arr, "A", 4);

        Helper.findMin(arr);
        Helper.findMax(arr);
        Helper.sort(arr);

        InOut.printArray(arr, "B", 5);
    }
}
