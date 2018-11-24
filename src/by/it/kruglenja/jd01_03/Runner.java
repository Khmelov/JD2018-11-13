package by.it.kruglenja.jd01_03;

import java.util.Scanner;

/**
 * Created by user on 17.11.2018.
 */
public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr);
        InOut.printArray(arr, "A", 3);
        Helper.findMin(arr);
        Helper.findMax(arr);
        Helper.sort(arr);

        double[][]matrixLeft = {{2,3},{7,8}};
        double[][]matrixRight = {{6,1},{9,5}};
        Helper.mul(matrixLeft, matrixRight);

    }

}