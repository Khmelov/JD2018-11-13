package by.it.zakharenko.jd01_04;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        buildOneDimArray(new Scanner(System.in).nextLine());
    }

    static void printMulTable(){
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9 ; j++) {
                System.out.printf("%d*%d=%-3d",i,j,i*j);
            }
            System.out.println();
        }
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%1$s[%2$ -3d]=%3$-9.4f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1) System.out.println();
        }
    }

    static void sort(double[] arr) {
        boolean wasShift;
        int len = arr.length - 1;
        do {
            wasShift = false;
            for (int i = 0; i < len; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                    wasShift = true;
                }
            }
            len--;
        } while (wasShift);
    }

    static void buildOneDimArray(String line){
        String[] sMas = line.trim().split(" ");
        double[] dMas = new double[sMas.length];
        for (int i = 0; i < sMas.length; i++) {
            dMas[i] = Double.parseDouble(sMas[i]);
        }
        double first = dMas[0];
        double last = dMas[dMas.length-1];
        printArray(dMas, "V", 5);
        sort(dMas);
        printArray(dMas, "V", 4);
        for (int i = 0; i < dMas.length; i++) {
            if(dMas[i] == first){
                System.out.println("Index of first element="+i);
            }
        }
        for (int i = 0; i < dMas.length; i++) {
            if(dMas[i] == last){
                System.out.println("Index of last element="+i);
            }
        }
    }
}























