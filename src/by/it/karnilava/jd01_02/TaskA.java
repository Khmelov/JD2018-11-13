package by.it.karnilava.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] mas=new int[10];
        for (int i = 0; i <mas.length ; i++) {
            mas[i]=scanner.nextInt();

        }
        step1 (mas);
        step2(mas);
        step3(mas);

	// write your code here
    }

    static void step1(int[] mas){
        int min=mas[0];
        int max=mas[0];
        for (int i = 0; i <mas.length ; i++) {
            if (mas[i]<min) min=mas[i];
            if (mas[i]>max) max=mas[i];

        }
        System.out.println(min+" " +max);
    }

    static void step2 (int [] mas) {
       double sum = 0;
        for (int i=0; i< mas.length ; i++) {
            sum = sum+ mas[i];
        }
        double avrg = sum/mas.length;
        for (int i =0; i<mas.length; i++)
            if (mas[i] < avrg) {
                System.out.println(mas[i]);
            }

    }

    static void step3 (int [] mas){
        int min=mas[0];

        for (int i = 0; i <mas.length ; i++) {
            if (mas[i]<min) min=mas[i];


        }

        for (int i=mas.length-1; i>=0; i--)
            if (mas[i] == min) {
                System.out.print(i+" ");

            }

        }





    }

