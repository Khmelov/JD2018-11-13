package by.it.vchernetski.jd01_02;

import java.util.Scanner;

public class TaskA {
    private static void step1(int[] mas) {
        int temp1 = mas[0];
        int temp2 = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < temp1) {
                temp1 = mas[i];
            }
            if (mas[i] > temp2) {
                temp2 = mas[i];
            }
        }
        System.out.println(temp1 + " " + temp2);
    }

    private static void step2(int[] mas) {
        System.out.println();
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum += mas[i];
        }
        double sr = (double) sum / mas.length;
        for (int i = 0; i < mas.length; i++) {
            if ((double) mas[i] < sr)
                System.out.print(mas[i] + " ");
        }
    }

    private static void step3(int[] mas) {
        System.out.println();
        int temp1 = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < temp1) {
                temp1 = mas[i];
            }
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (temp1 == mas[i])
                System.out.print(i + " ");

        }
    }

    public static void main(String[] args) {
        int[] mas = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            mas[i] = sc.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }
}
