package by.it.zakharenko.jd01_03;

import by.it.zakharenko.jd01_04.Helper;
import by.it.zakharenko.jd01_04.InOut;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        double[] array= InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"v", 3);

        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);

    }
}
