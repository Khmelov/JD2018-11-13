package by.it.malishevskiy.jd01_02;

import java.util.ArrayList;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длинну матрицы: ");
        int n = scanner.nextInt();
        int[][] mas = step1(n);
        step2(mas);
        step3(mas);
    }

    static int[][] step1(int n) {
            int[][] mas = new int[n][n];
            int max = 0;
            int min = 0;
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[i].length; j++) {
                    mas[i][j] = ((int) (Math.random() * (n * 2 + 1))) - n;
                    System.out.print(mas[i][j] + "\t");
                }
            }
        for (int[] mas1 : mas) {
            for (int k = 0; k < mas.length; k++) {
                if (mas1[k] == n) {
                    max = mas1[k];
                }
                if (mas1[k] == -n) {
                    min = mas1[k];
                }
            }
        }
        while ((max != n && min != -n) || (max == n && min != -n) || (max != n && min == -n)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                }
            }
            for (int q = 0; q < mas.length; q++) {
                for (int k = 0; k < mas.length; k++) {
                    if (mas[q][k] == n) {
                        max = mas[q][k];
                    }
                    if (mas[q][k] == -n) {
                        min = mas[q][k];
                    }
                }
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int q = 0; q < mas.length; q++) {
                System.out.print(mas[i][q]);
            }
            System.out.println();
        }
        return mas;
    }

    static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            int a1 = 0;
            int a2 = 0;
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] >= 0) {
                    a1 = j;
                    break;
                }
            }
            for (int q = a1 + 1; q < mas.length; q++) {
                if (mas[i][q] >= 0) {
                    a2 = q;
                    break;
                }
            }
            if (a2 != 0) {
                while (a2 - 1 != a1) {
                    sum += mas[i][a2 - 1];
                    a2 -= 1;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    static int[][] step3(int[][] mas) {
        int max = 0;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        ArrayList<Integer> newRows = new ArrayList<>();
        ArrayList<Integer> newcol = new ArrayList<>();
        for (int i = 0; i < mas.length; i++) {
            for (int q = 0; q < mas[0].length; q++) {
                if (mas[i][q] > max) {
                    max = mas[i][q];
                }
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] == max) {
                    rows.add(i);
                    break;
                }
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[j][i] == max) {
                    col.add(i);
                    break;
                }
            }
        }
        for (int i = 0; i < mas.length; i++) {
            int counter = 0;
            for (int j = 0; j < rows.size(); j++) {
                if (i == rows.get(j)) {
                    break;
                } else {
                    counter += 1;
                    if (counter == rows.size()) {
                        newRows.add(i);
                    }
                }
            }
        }
        for (int i = 0; i < mas[0].length; i++) {
            int counter = 0;
            for (int j = 0; j < col.size(); j++) {
                if (i == col.get(j)) {
                    break;
                } else {
                    counter += 1;
                    if (counter == col.size()) {
                        newcol.add(i);
                    }
                }
            }
        }
        int[][] mas2 = new int[newRows.size()][newcol.size()];
        for (int i = 0; i < mas2.length; i++) {
            for (int j = 0; j < mas2[0].length; j++) {
                mas2[i][j]=mas[newRows.get(i)][newcol.get(j)];
            }
        }
        for (int i = 0; i < mas2.length; i++) {
            for (int i1 = 0; i1 < mas2[0].length; i1++) {
                System.out.print(mas2[i][i1]);
            }
            System.out.println();
        }
        return mas2;
    }
}