package by.it.markelov.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        int mas[] = new int[10];
        Scanner scr = new Scanner(System.in);
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scr.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int mas[]) {
        int min = mas[0];
        int max = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (min > mas[i]) min = mas[i];
            if (max < mas[i]) max = mas[i];
        }
        System.out.println(min+" "+max);
    }

    static void step2(int mas[]) {
        int sum=0;
        double avg=0;
        for (int element: mas) {
            sum+=element;
        }
        avg=sum/mas.length;
        for (int element: mas) {
            if (element<avg) System.out.print(element+" ");
        }
        System.out.println();

    }

    static void step3(int mas[]) {
        int min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (min > mas[i]) min = mas[i];
        }
        for (int i = mas.length-1; i >= 0; i--) {
            if (mas[i]==min) System.out.print(i+" ");

        }

    }
}
