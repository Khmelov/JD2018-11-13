package by.it.mnovikov.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        step1(n);

    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        boolean check = true;
        while (check) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mas[i][j] == n) check = false;
                    if (mas[i][j] == -n) check = false;
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
        }
        return mas;
    }

    private static int step2(int[][] mas) {
        int sum = 0;

        for (int i = 0; i < mas.length; i++) {
            int elem1 = 0;
            int elem2 = 0;
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] >= 0) {
                    elem1 = j;
                    break;
                }
            }
            for (int j = elem1 + 1; j < mas[i].length; j++) {
                if (mas[i][j] >= 0) {
                    elem2 = j;
                    break;
                }
            }
            if (elem2 - elem1 <= 1) break;
            else for (int j = elem1 + 1; j < elem2; j++) {
                sum += mas[i][j];
            }
        }
        return sum;
    }
}