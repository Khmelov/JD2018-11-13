package by.it.lobkova.jd01_02;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main( String[] args) {
        int[][] mas = step1(scanInputValues());
        System.out.println(step2(mas));
        printArray(step3(mas));
    }

    private static int[][] step1(int n){
        int[][] arr = generateRandomArray(n);
        printArray(arr);
        return arr;
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        int buffSum = 0;
        int p = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] >= 0) {
                    p++;
                    if (p == 2) break;
                    continue;
                }

                if (p == 1) {
                    buffSum += mas[i][j];
                }
            }

            if (p == 1) buffSum = 0;
            sum += buffSum;
            buffSum = 0;
            p = 0;
        }
        return sum;
    }

    private static int[][] convertListToArr(List<List<Integer>> list) {
        int[][] arr = new int[list.size()][list.get(0).size()];
        for (List<Integer> item : list) {
            item.toArray();
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }

        return arr;
    }

    private static int[][] step3(int[][] mas) {
        int max = mas[0][0];
        List<Point> list = new ArrayList<Point>();

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > max) {
                    max = mas[i][j];
                    list.clear();
                    list.add(new Point(i, j));
                } else if (mas[i][j] == max) {
                    list.add(new Point(i, j));
                }
            }
        }

        List<List<Integer>> returnList = new ArrayList<>();

        for (Point item : list) {
            System.out.println(item);
        }

        boolean c = false;

        for (int i = 0; i < mas.length; i++) {
            for (Point item : list) {
                if (i == item.x) {
                    c = true;
                    break;
                }
            }

            if (c) {
                c = false;
                continue;
            }

            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < mas.length; j++) {
                boolean c2 = false;
                for (Point item : list) {
                    if (j == item.y) {
                        c2 = true;
                        break;
                    }
                }

                if (c2) {
                    continue;
                } else {
                    row.add(mas[i][j]);
                }
            }
            returnList.add(row);
        }

        return convertListToArr(returnList);
    }

    private static void printArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int scanInputValues(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        return n;
    }

    private static int[][] generateRandomArray(int n){
        Random r = new Random();
        int[][] mas = new int[n][n];
        boolean isExistN = false;
        boolean isExistMinesN = false;

        while(!(isExistN && isExistMinesN)) {
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length; j++) {
                    mas[i][j] = r.nextInt(n * 2 + 1) - n;
                    if (mas[i][j] == -n) isExistMinesN = true;
                    if (mas[i][j] == n) isExistN = true;
                }
            }
        }
        return mas;
    }


}
