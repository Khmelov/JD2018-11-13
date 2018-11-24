package by.it.markelov.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n;
        n = scr.nextInt();
        int mas [][]=step1 (n);
          for (int[] massive : mas) {
            for (int element : massive) {
               System.out.println(element);
            }

        }

    }

    static int[][] step1(int n) {
        int mas[][] = new int[n][n];
        Random rdm = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; i < n; j++) {
                mas[i][j] = rdm.nextInt();
                /*while ((-n) > mas[i][j] & mas[i][j] > n)
                    mas[i][j] = rdm.nextInt();*/

            }
        }
        return mas;
    }
}