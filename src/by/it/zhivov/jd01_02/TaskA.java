package by.it.zhivov.jd01_02;

import java.util.Scanner;


public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }

        step1(mas);
        step2(mas);
        step3(mas);

    }

    static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < min) {
                min = mas[i];
            }
            if (mas[i] > max) {
                max = mas[i];
            }
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum += mas[i];
        }
        double aver = sum / mas.length;

        for (int k = 0; k < mas.length; k++) {
            if (mas[k] < aver) {
                System.out.println(mas[k]);
            }
        }

    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < min) {
                min = mas[i];
            }
        }
        for (int k = mas.length - 1; k >= 0; k--) {
            if (mas[k] == min) {
                System.out.print(k + " ");
            }
        }
    }

}
