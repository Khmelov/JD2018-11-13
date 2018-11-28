package by.it.denisova.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        step1(n);
    }

    public static int[][] step1(int n) {
        Random rand = new Random();
        int[][] mas = new int[n][n];
        boolean generate = true;
        while (generate) {
            boolean containN = false;
            boolean containMN = false;
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length; j++) {
                    mas[i][j] = rand.nextInt(mas.length * 2 + 1) - mas.length;
                    if (mas[i][j] == n) {
                        containN = true;
                    } else if (mas[i][j] == -n) {
                        containMN = true;
                    }
                }
            }
            generate = !(containN && containMN);
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        return mas;
    }


}
