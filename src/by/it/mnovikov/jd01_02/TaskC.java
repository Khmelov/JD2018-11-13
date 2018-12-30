package by.it.mnovikov.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        step1(n);
    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        boolean check = true;
        while (check) {
            boolean mark1 = false, mark2 = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mas[i][j] == n) mark1 = true;
                    if (mas[i][j] == -n) mark2 = true;
                }
            }
            check=!(mark1 && mark2);
        }
        for (int[] str : mas) {
            for (int elem : str) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        return mas;
    }

    private static int step2(int[][] mas) {
        int sum = 0;

        for (int[] ma : mas) {
            int elem1 = 0;
            int elem2 = 0;
            for (int j = 0; j < ma.length; j++) {
                if (ma[j] >= 0) {
                    elem1 = j;
                    break;
                }
            }
            for (int j = elem1 + 1; j < ma.length; j++) {
                if (ma[j] >= 0) {
                    elem2 = j;
                    break;
                }
            }
            if (elem2 - elem1 <= 1) break;
            else for (int j = elem1 + 1; j < elem2; j++) {
                sum += ma[j];
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[ ][ ] step3(int[ ][ ] mas){
        return mas;
    }
}