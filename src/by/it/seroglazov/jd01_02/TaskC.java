package by.it.seroglazov.jd01_02;

import java.util.*;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas = new int[n][n];
        mas = step1(n);
        System.out.println(step2(mas));
        /*int[][] mas = {
                {1, 0, 1, 1},
                {1, 0, 1, 1},
                {1, 0, 1, 1},
                {0, 0, 0, 0}
        };*/
        int[][] outMas = step3(mas);
        if (outMas.length == 0) {
            System.out.println("Zero length mas");
        } else {
            for (int i = 0; i < outMas.length; i++) {
                for (int j = 0; j < outMas[0].length; j++) {
                    System.out.print(outMas[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    static int[][] step1(int n) {
        Random random = new Random();
        int[][] mas = new int[n][n];
        boolean wasPlusN = false;
        boolean wasMinusN = false;
        while (!wasPlusN || !wasMinusN) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mas[i][j] != n && mas[i][j] != -n) {
                        mas[i][j] = random.nextInt(2 * n + 1) - n; // Random from [-n .. n]
                        if (mas[i][j] == -n) wasMinusN = true;
                        else if (mas[i][j] == n) wasPlusN = true;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        return mas;
    }

    static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            boolean wasPositive = false;
            for (int j = 0; j < mas[i].length; j++) {
                if (!wasPositive && mas[i][j] > 0) wasPositive = true; // Find first positive
                else if (wasPositive && mas[i][j] > 0) break; // Find Second positive - end reading this line
                else if (wasPositive) sum += mas[i][j];
            }
        }
        return sum;
    }

    static int[][] delFromArrayByMap(int[][] mas, boolean[] delRows, boolean[] delCols) {
        // Firstly delete rows (i)
        // Search first row for deleting
        int iNum = -1;
        for (int i = 0; i < delRows.length; i++) {
            if (delRows[i]) {
                iNum = i;
                break;
            }
        }
        if (iNum != -1) {
            if (delRows.length == 1) return new int[0][0];
            else {
                // If we find row for deleting - delete it
                int[][] outMas = new int[mas.length - 1][mas[0].length];
                boolean[] outDelRows = new boolean[delRows.length - 1];

                for (int i = 0; i < mas.length; i++) {
                    for (int j = 0; j < mas[i].length; j++) {
                        if (i < iNum) outMas[i][j] = mas[i][j];
                        else if (i > iNum) outMas[i - 1][j] = mas[i][j];
                        // If i == iNum - do nothing
                    }
                    if (i < iNum) outDelRows[i] = delRows[i];
                    else if (i > iNum) outDelRows[i - 1] = delRows[i];
                    // If i == iNum - do nothing
                }
                // And recursivly call itself
                return delFromArrayByMap(outMas, outDelRows, delCols);
            }
        } else {
            // If we didn't find row for deleting - search column for deleting
            int jNum = -1;
            for (int j = 0; j < delCols.length; j++) {
                if (delCols[j]) {
                    jNum = j;
                    break;
                }
            }
            if (jNum != -1) {
                if (delCols.length == 1) return new int[0][0];
                else {
                    // If we find column for deleting - delete it
                    int[][] outMas = new int[mas.length][mas[0].length - 1];
                    boolean[] outDelCols = new boolean[delCols.length - 1];

                    for (int i = 0; i < mas.length; i++) {
                        for (int j = 0; j < mas[i].length; j++) {
                            if (j < jNum) {
                                outMas[i][j] = mas[i][j];
                                outDelCols[j] = delCols[j];
                            } else if (j > jNum) {
                                outMas[i][j - 1] = mas[i][j];
                                outDelCols[j - 1] = delCols[j];
                            }
                            // If j == jNum - do nothing
                        }
                    }
                    // And recursivly call itself
                    return delFromArrayByMap(outMas, delRows, outDelCols);
                }
            } else return mas; // If there is no any rows and any columns for deleting
        }
    }

    // In this method, mas - must be "rectangle" array (one length of each row)
    static int[][] step3(int[][] mas) {

        int maxVal = mas[0][0];

        // For starting just find max value
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > maxVal) maxVal = mas[i][j];
            }
        }

        boolean[] delRows = new boolean[mas.length];
        boolean[] delCols = new boolean[mas[0].length];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] == maxVal) {
                    delRows[i] = true;
                    delCols[j] = true;
                }
            }
        }

        return delFromArrayByMap(mas, delRows, delCols);
    }

}




























