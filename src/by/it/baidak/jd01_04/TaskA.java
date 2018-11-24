package by.it.baidak.jd01_04;

import by.it.baidak.jd01_03.Helper;
import by.it.baidak.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        TaskA.printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        TaskA.buildOneDimArray(line);
    }

    static void printMulTable(){
        for (int i = 2; i < 10; i++){
            for (int j = 2; j < 10; j++){
                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double fElem = array[0]; double lElem = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if(array[i] == fElem) System.out.println("Index of first element=" + i);
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] == lElem) System.out.println("Index of last element=" + i);
        }
    }


}
