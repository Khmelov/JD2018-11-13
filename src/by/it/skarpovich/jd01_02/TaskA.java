package by.it.skarpovich.jd01_02;

import java.util.Scanner;

class TaskA {
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
            /* Второй способ цикла for для массива
            for (int i = 0; i <mas.length; i++) {
                if (min > mas[i]) min = mas[i];
                if (max < mas[i]) max = mas[i];
            }
            */


        for (int a : mas) {
            if (min > a) min = a;
            if (max < a) max = a;
        }
        System.out.println(min + " " + max);
        System.out.println();
    }

    static void step2(int[] mas) {
        int sum = 0;
        for (int b : mas) sum = sum + b;    //Считаем сумму элементов массива
        double average = (double) sum / mas.length; //Вычисляем среднее арифметическое элементов массива c приведением(!)
        //System.out.println(average);
        for (int b : mas) {
            if (b < average) {
                System.out.println(b + " ");  //Находим элементы < среднего арифметического(double) и выводим в консоль

            }
        }
        System.out.println();
    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int element : mas) {
            if (min > element) min = element;
        }

            for (int i = mas.length - 1; i >= 0; i--) {
                if (min == mas[i]) {
                    System.out.print(i + " ");
                }
            }

        }
    }




