package by.it.skarpovich.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        int n;

        System.out.println("Введите размерность матрицы NxN");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] mas = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = ((int) (Math.random() * (2 * n + 1)) - n);
            }
        }
        step1(n);
        step2(mas);
        step3(mas);
    }


    static int[][] step1(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ((int) (Math.random() * (2 * n + 1)) - n);
            }
        }
        for (int i = 0; i < n; i++, System.out.println()) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        return matrix;
    }


    static int step2(int[][] mas) {
        int sum = 0;
        int counter = 0;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {

                if (counter == 1 && mas[i][j] < 0) {
                    sum = sum + mas[i][j];
                }
                if (mas[i][j] > 0) {
                    counter++;
                }

                if (counter == 2) {
                    break;
                }
            }
            counter = 0;

        }
        System.out.println("Сумма между первым и вторым положительными элементами:");
        System.out.println(sum);

        return sum;
    }

    static int[][] step3(int[][] mas) {
        int min = mas[0][0];
        int max = mas[0][0];

        for (int i = 0; i < mas.length; i++, System.out.println()) {
            for (int j = 0; j < mas.length; j++) {
                if (min > mas[i][j]) min = mas[i][j];
                if (max < mas[i][j]) max = mas[i][j];

            }

        }
        System.out.println(min);
        System.out.print(max);
        return mas;
    }

}

