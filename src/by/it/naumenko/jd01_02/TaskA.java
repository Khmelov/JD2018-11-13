package by.it.naumenko.jd01_02;

import java.util.Scanner;

public class TaskA {

    static void step1(int[] mas) {
        int max = mas[0];
        int min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < min)
                min = mas[i];
            if (mas[i] > max)
                max = mas[i];
        }
        System.out.println(min + " " + max);


    }

    static void step2(int[] mas) {
        int sum=0;
        double srZnach;
        for (int i = 0; i <mas.length ; i++) {
            sum+=mas[i];
        }
        srZnach=sum/(mas.length);
        for (int i = 0; i <mas.length ; i++) {
            if(mas[i]< srZnach)
                System.out.print(mas[i]+" ");
        }
        System.out.println();

    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < min)
                min = mas[i];
        }

        for (int i = mas.length-1; i >=0 ; i--) {
            if(mas[i]==min)
                System.out.print(i+" ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int[] mas = new int[10];
        for (int j = 0; j < mas.length; j++) {
            mas[j] = sc.nextInt();

        }
        step1(mas);

        step2(mas);
        step3(mas);

        // write your code here
    }
}
