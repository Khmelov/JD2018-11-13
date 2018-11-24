package by.it.nickgrudnitsky.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int ma : mas) {
            if (ma >= max) max = ma;
            if (ma <= min) min = ma;
        }
        System.out.print(min + " " + max);
    }

    static void step2(int[] mas) {
        double sum = 0;
        for (int ma : mas) {
            sum += ma;
        }
        for (int ma : mas) {
            if (ma < sum / mas.length) System.out.println(ma);
        }
    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int ma : mas) {
            if (ma <= min) min = ma;
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min) System.out.print(i + " ");
        }
    }
}
