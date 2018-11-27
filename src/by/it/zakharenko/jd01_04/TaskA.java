package by.it.zakharenko.jd01_04;

import java.util.Scanner;

public class TaskA {

        private static void printMulTable() {
            for (int i = 2; i <= 9; i++) {
                for (int j = 2; j <= 9; j++) {
                    System.out.printf("%1d*%1d=%-2d ", i, j, j * i);
                }
                System.out.println();
            }
        }

         private static void buildOneDimArray(String line){
            double[] array = InOut.getArray(line);
            double start = array[0];
            double stop = array[array.length-1];
            InOut.printArray(array, "V", 5);
            Helper.sort(array);
            InOut.printArray(array, "V", 4);
            for (int i = 0; i < array.length; i++) {
                if (start == array[i]) {
                    System.out.println("Index of first element=" + i);
                    break;
                }
            }
            for (int i = 0; i < array.length; i++) {
                if (stop == array[i]) {
                    System.out.println("Index of last element=" + i);
                    break;
                }
            }
        }

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        buildOneDimArray (s);
    }
}
