package by.it.nickgrudnitsky.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        double max = Helper.findMax(array);
        double min = Helper.findMin(array);
        Helper.sort(array);
        /*double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        double[] vector = {1,2,3};
        double[] rez = Helper.mul(matrix,vector);
        InOut.printArray(rez);*/
    }
}
