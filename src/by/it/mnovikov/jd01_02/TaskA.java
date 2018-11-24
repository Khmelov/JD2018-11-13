package by.it.mnovikov.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by user on 15.11.2018.
 */
public class TaskA {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int[] mas = new int[10];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = sc.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int ma : mas) {
            if (ma < min) {
                min = ma;
            }
            if (ma > max) {
                max = ma;
            }
        }
        System.out.print(min + " " + max);
        System.out.println();
    }

    static void step2(int[] mas) {
        double sum = 0;
        for (int element : mas) {
            sum += element;
        }
        for (int element : mas) {
            if (element < (sum / mas.length)) System.out.println(element);
        }
        System.out.println();
    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int ma : mas) {
            if (ma < min) {
                min = ma;
            }
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i]==min)
            System.out.print(i + " ");
        }
    }
}
