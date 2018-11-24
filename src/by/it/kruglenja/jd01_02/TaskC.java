package by.it.kruglenja.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mas[][] = step1(n);
        step2(mas);
        step3(mas);
    }

    private static int[][] step1(int n) {
        int mas[][] = new int[n][n];
        boolean flag1 = false;
        boolean flag2 = false;
        int i;
        for (i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                if (mas[i][j] == -n) {
                    flag1 = true;
                }
                if (mas[i][j] == n) {
                    flag2 = true;
                }
                //Array validation
                if ((i == (mas.length - 1) && (j == (mas[i].length - 1) && (!flag1 || !flag2)))) {
                    i = 0;
                    flag1 = false;
                    flag2 = false;
                }
            }
        }
        for (i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf("[% -3d]", mas[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        return mas;
    }
    private static int step2(int[][] mas) {
        int sum = 0;
        for (int x = 0; x < mas.length; x++) {
            int ind1 = -1;
            int ind2 = -1;
            for (int j = 0; j < mas[x].length; j++) {
                if (mas[x][j] > 0)
                    if (ind1 == -1) {
                        ind1 = j;
                    }else if(ind2 == -1){
                        ind2 = j;
                    }else
                        continue;
                if (ind1 >=0 && ind2 > 0) {
                    for (int k = ind1 + 1; k < ind2; k++) {
                        sum += mas[x][k];
                    }
                }
            }
        }
        System.out.println(sum);
        System.out.println();
        return sum;
    }


    private static int[][]step3(int[][]mas){
        mas = new int[][]{{-1, 2, -2}, {-2, -2, -6}};
        boolean[] skipRow = new boolean[mas.length];
        boolean[] skipCol = new boolean[mas[0].length];
        int x = 0;
        int y = 0;

        int max = mas[0][0];
        for (int i = 0; i <mas.length ; i++) {               //Находим максимум
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf("[% -3d]", mas[i][j]);
                if (mas[i][j] > max) {
                    max = mas[i][j];
                }
            }System.out.println();
        }
        System.out.println();

        for (int j = 0; j < mas.length; j++) {               //Забиваем массив пропускоами по max
            for (int k = 0; k < mas[j].length; k++) {
                if (mas[j][k] == max) {
                    skipRow[j] = true;
                    skipCol[k] = true;
                }
            }
        }

        for (boolean aSkipRow : skipRow) {                    ///Количество строк нового массива
            if (!aSkipRow) {
                x++;
            }
        }
        for (boolean aSkipCol : skipCol) {                    //Колличество столбцов нового массива
            if (!aSkipCol) {
                y++;
            }
        }

        int[][] multp = new int[x][y];
        int row = 0;
        for (int j = 0; j < mas.length; j++) {
            int col = 0;
            boolean flag3 = false;
            for (int k = 0; k < mas[j].length; k++) {
                if (!skipRow[j] && !skipCol[k]) {
                    multp[row][col] = mas[j][k];
                    System.out.printf("[% -3d]", multp[row][col]);
                    col++;
                    flag3 = true;
                }
            }
            if (flag3) {
                System.out.println();
            }
        }
        return mas;
    }
}