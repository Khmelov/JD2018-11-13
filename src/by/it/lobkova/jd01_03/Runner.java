package by.it.lobkova.jd01_03;

import java.util.Random;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        double [][] mas1 = getArray(scanInputN(), scanInputM());
        double [][] mas2 = getArray(scanInputN(), scanInputM());
        double [][] z = (Helper.mul(mas1, mas2));

        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z.length; j++) {
                System.out.print(z[i][j]);
            }
        }
        System.out.println();
    }

    private static double[][] getArray(int n, int m){
        double[][] arr = generateRandomArray(n, m);
        printArray(arr);
        return arr;
    }

    private static int scanInputN(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        return n;
    }

    private static int scanInputM(){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        return m;
    }

    private static double[][] generateRandomArray(int n, int m){
        Random r = new Random();
        double[][] mas = new double[n][m];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = r.nextInt(4);
            }

        }
        return mas;
    }

    static void printArray(double[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
