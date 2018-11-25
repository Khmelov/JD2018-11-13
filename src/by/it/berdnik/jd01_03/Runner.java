package by.it.berdnik.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

import static by.it.berdnik.jd01_03.Helper.*;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr);
        InOut.printArray(arr, "A", 3);
        System.out.println();
        System.out.println("Мин. массива = " + findMin(arr));
        System.out.println("Макс. массива = " + findMax(arr));
    }
}
