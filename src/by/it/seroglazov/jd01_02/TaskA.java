package by.it.seroglazov.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mas = new int[10];
        System.out.println("Please, enter 10 int values.");
        for (int i = 0; i < 10; i++) {
            mas[i] = sc.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);

    }

    static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int i = 0; i < 10; i++) {
            if (mas[i] < min) min = mas[i];
            if (mas[i] > max) max = mas[i];
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[] mas) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += mas[i];
        }
        // arithmetical mean
        double arMean = (double) sum / mas.length;
        for (int i = 0; i < 10; i++) {
            if (mas[i] < arMean) {
                System.out.print(mas[i] + " ");
            }
        }
        System.out.println();
    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int i = 0; i < 10; i++) {
            if (mas[i] < min) min = mas[i];
        }
        for (int i = 9; i >= 0; i--) {
            if (mas[i] == min) System.out.print(i + " ");
        }
        System.out.println();
    }
}



























