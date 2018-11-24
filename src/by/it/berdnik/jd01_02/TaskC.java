package by.it.berdnik.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        for (int i = 0; i < mas.length; i++)
            for (int j = 0; j < n; j++) {
                mas[i][j] = ((int) (Math.random() * (n * 2 + 1)) - n);
                System.out.print(mas[i][j] + " ");
            }
        System.out.println();
        return mas;
    }

    private static int step2(int[][] mas) {
        int indexStart = 0;
        int indexEnd = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (i > 0) {
                    indexStart = i;
                    break;
                }
                for (int k = indexStart + 1; k < mas.length; k++) {
                    if (k > 0) {
                        indexEnd = k;
                        break;
                    }
                }
                int sum = 0;
                for (int l = mas[i + 1][j]; l < indexEnd; l++) {
                    sum += l;
                    System.out.println(sum);
                }
            }
        }
        System.out.println();
        return indexStart;
    }
}
