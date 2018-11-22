package by.it.nickgrudnitsky.jd01_02;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas = step1(n);
        //int[][] mas3 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        step2(mas);
        step3(mas);
    }

    static int[][] step1(int n) {
        int a = 0;
        int b = 0;
        int[][] mas = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                mas[i][i1] = (int) (Math.random() * (2 * n + 1)) - n;
            }
        }
        for (int[] ma : mas) {
            for (int i3 = 0; i3 < mas.length; i3++) {
                if (ma[i3] == n) a = ma[i3];
                if (ma[i3] == -n) b = ma[i3];
            }
        }
        while ((a != n && b != -n) || (a == n && b != -n) || (a != n && b == -n)) {
            for (int i = 0; i < n; i++) {
                for (int i1 = 0; i1 < n; i1++) {
                    mas[i][i1] = (int) (Math.random() * (2 * n + 1)) - n;
                }

            }
            for (int i2 = 0; i2 < mas.length; i2++) {
                for (int i3 = 0; i3 < mas.length; i3++) {
                    if (mas[i2][i3] == n) a = mas[i2][i3];
                    if (mas[i2][i3] == -n) b = mas[i2][i3];
                }
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int i1 = 0; i1 < mas.length; i1++) {
                System.out.print(mas[i][i1]);
            }
            System.out.println();
        }
        return mas;
    }

    static int step2(int[][] mas) {
        int amount = 0;
        for (int i = 0; i < mas.length; i++) {
            int a1 = 0;
            int a2 = 0;
            for (int i1 = 0; i1 < mas.length; i1++) {
                if (mas[i][i1] >= 0) {
                    a1 = i1;
                    break;
                }
            }
            for (int i2 = a1 + 1; i2 < mas.length; i2++) {
                if (mas[i][i2] >= 0) {
                    a2 = i2;
                    break;
                }
            }
            if (a2 != 0) {
                while (a2 - 1 != a1) {
                    amount += mas[i][a2 - 1];
                    a2 -= 1;
                }
            }
        }
        System.out.println(amount);
        return amount;
    }

    static int[][] step3(int[][] mas) {
        int max = 0;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();
        ArrayList<Integer> newRows = new ArrayList<>();
        ArrayList<Integer> newcolumns = new ArrayList<>();
        for (int i = 0; i < mas.length; i++) {
            for (int i1 = 0; i1 < mas[0].length; i1++) {
                if (mas[i][i1] > max) {
                    max = mas[i][i1];
                }
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int i1 = 0; i1 < mas[0].length; i1++) {
                if (mas[i][i1] == max) {
                    rows.add(i);
                    break;
                }
            }
        }
        for (int i1 = 0; i1 < mas.length; i1++) {
            for (int i = 0; i < mas[0].length; i++) {
                if (mas[i][i1] == max) {
                    columns.add(i1);
                    break;
                }
            }
        }
        for (int i = 0; i < mas.length; i++) {
            int counter = 0;
            for (int i1 = 0; i1 < rows.size(); i1++) {
                if (i == rows.get(i1)) {
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
            for (int i1 = 0; i1 < columns.size(); i1++) {
                if (i == columns.get(i1)) {
                    break;
                } else {
                    counter += 1;
                    if (counter == columns.size()) {
                        newcolumns.add(i);
                    }
                }
            }
        }
        int[][] mas2 = new int[newRows.size()][newcolumns.size()];

        for (int i = 0; i < mas2.length; i++) {
            for (int i1 = 0; i1 < mas2[0].length; i1++) {
                mas2[i][i1]=mas[newRows.get(i)][newcolumns.get(i1)];
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