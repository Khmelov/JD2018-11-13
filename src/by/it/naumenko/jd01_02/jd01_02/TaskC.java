package by.it.naumenko.jd01_02.jd01_02;

import java.util.Random;
import java.util.Scanner;


public class TaskC {

    static void printArray(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printArrayNew(int[][] mas) {
        for (int i = 0; i < mas.length - 1; i++) {
            for (int j = 0; j < mas.length - 1; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] step1(int n) {
        boolean flagPol = false;
        boolean flagOtr = false;
        int[][] mas = new int[n][n];
        int kol = 0;
        while (true) {
            kol++;
            Random rnd = new Random();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = rnd.nextInt(n * 2 + 1) - n;
                    if (mas[i][j] == -n)
                        flagOtr = true;
                    if (mas[i][j] == n)
                        flagPol = true;
                }
            }
            if (flagOtr == true && flagPol == true)
                break;

        }
        printArray(mas);
        //System.out.println(kol);
        return mas;
    }

    static int step2(int[][] mas) {
        int summa = 0;
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum = 0;
            int kol = 0;
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > 0) {
                    kol++;
                }
                if (kol == 1 && mas[i][j] < 0) {
                    sum += mas[i][j];
                }
            }
//            if (kol == 1)
//                sum = 0;
//            System.out.println(sum);
//            System.out.println("Сумма элементов " + i + "ой" + " строки = " + sum);
            summa += sum;
        }
        //System.out.println(summa);
        return summa;

    }

    //максимальный элемент
    static int maxArray(int[][] mas) {
        int max = mas[0][0];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > max) {
                    max = mas[i][j];
                }
            }
        }
        return max;
    }

    //номер строки шде максимальный элемент
    static int maxArrayIndI(int[][] mas) {
        int max = maxArray(mas);
        int ind_i = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    ind_i = i;
                }
            }
        }
        return ind_i;
    }

    //номер столбца шде максимальный элемент
    static int maxArrayIndJ(int[][] mas) {
        int max = maxArray(mas);
        int ind_j = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    ind_j = j;
                }
            }
        }
        return ind_j;
    }

    static int[][] step3(int[][] mas) {

        //int ind_i = maxArrayIndI(mas);
        //int ind_j = maxArrayIndJ(mas);
        boolean[] delCol = new boolean[mas.length];
        boolean[] delRow = new boolean[mas.length];

        int max = maxArray(mas);
        int col = mas.length;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    delCol[j] = true;
                    delRow[i] = true;
                    col--;
                }
            }
        }

        int k = 0;
        int[][] matrix = new int[col][col];
        System.out.println(col);
        for (int i = 0; i < mas.length; i++) {
            int t=0;
            boolean zap=false;
            for (int j = 0; j < mas[i].length; j++) {
                if ((delRow[i] == false) && (delCol[j] == false)) {
                    matrix[k][t] = mas[i][j];
                    t++;
                    zap=true;
                }
            }
            if(zap)
                k++;
        }

//        System.out.println();
//        for (int i = 0; i < delCol.length; i++) {
//            System.out.print(delCol[i] + "  ");
//        }
//
//        System.out.println();
//        for (int i = 0; i < delRow.length; i++) {
//            System.out.print(delRow[i] + "  ");
//        }

        System.out.println();
        printArray(matrix);
        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[][]mas = new int[n][n];
//        mas=step1(n);
        //System.out.println(step1(n));

//        int[][] massiv={
//                {1,-5,-6,-4,3,5},
//                {-5,-4,2,-3,4,2},
//                {4,2,-1,-5,-3,5},
//                {-8,-7,-4,-3,-2},
//        };

        //int [][] massiv2=step1(n);
        step1(n);
        step2(step1(n));
        step3(step1(n));


    }

}
