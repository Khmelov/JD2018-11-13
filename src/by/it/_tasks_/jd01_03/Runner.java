package by.it._tasks_.jd01_03;

import java.util.Scanner;


public class Runner {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"V", 3);
        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));

    }
//
}
