package by.it.karnilava.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность матрицы");
        int n = scanner.nextInt();

        int[][] mas;
        mas = step1(n);
        step2(mas, n);
        //step3


    }

    static int[][] step1(int n) {
        int[][] mas = new int[n][n];


        int min = mas[0][0];
        int max = mas[0][0];
        while (min != -n && max != n) {
            fillInMatrix(n, mas);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mas[i][j] < min) min = mas[i][j];
                    if (mas[i][j] > max) max = mas[i][j];
                }
            }
        }
        printMatrix(mas, n);

        return mas;
    }

    static int step2(int[ ][ ] mas, int n) {
        int y=0;
        for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                if (mas[i][j] >0) {
                    y=mas[i][j];

                }
            }
        }
        return y;
    }

    private static void fillInMatrix(int n, int[][] mas) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = new Random().nextInt(2 * n + 1) - n;
            }

        }
    }

    public static void printMatrix(int[][] mas, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();

        }
    }
}