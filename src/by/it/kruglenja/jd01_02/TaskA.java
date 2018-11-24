package by.it.kruglenja.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new  int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    private static void step1(int[] mas){
        int min = mas[0];
        int max = mas[0];

        for (int i : mas) {
            if (min > i) min = i;
            if (max < i) max = i;
        }
        System.out.println(min + " " + max);
    }
    private static void step2(int[] mas){
        int sum = 0;
        for (int ma : mas) {
            sum += ma;
        }
        double average = sum / mas.length;

        for (int ma : mas) {
            if (ma < average)
                System.out.print(ma + " ");

        }
        System.out.println();
    }
    private static void step3(int[] mas){
        int min = mas[0];
        for (int i = 1; i < mas.length; i++) {
            min = Math.min(min, mas[i]);
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}