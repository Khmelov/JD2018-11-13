package by.it.kruglenja.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Количество людей:");

        int staffAmount = sc.nextInt();

        int quart = 4;

        sc.nextLine();

        String[] names = new String[staffAmount];

        System.out.println("Фамилии: ");

        for (int i = 0; i < staffAmount; i++) {

            names[i] = sc.nextLine();

        }
        int[][] payment = new int[staffAmount][quart];

        for (int i = 0; i < staffAmount; i++) {

            String s = names[i];

            System.out.println("Введите зарплату для " + names[i]);

            String line = sc.nextLine();

            String[] pay = line.trim().split(" ");

            for (int j = 0; j < 4; j++) {

                payment[i][j] = Integer.parseInt(pay[j]);

            }

        }

        int quartSum = 0;

        System.out.println("------------------------------------------------------------");

        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s \n", "Фамилия", "Квартал1", "Квартал2"

                , "Квартал3", "Квартал4", "Итого");

        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < payment.length; i++) {

            System.out.printf("%10s:", names[i]);

            int sumByName = 0;

            for (int j = 0; j < payment[i].length; j++) {

                System.out.printf("%-10d", payment[i][j]);

                sumByName += payment[i][j];

            }

            quartSum += sumByName;

            System.out.printf("%-10d", sumByName);

            if (i < payment.length) {

                System.out.println();

            }

        }

        System.out.println("------------------------------------------------------------");

        System.out.printf("%-10s%-10d", "Итого", quartSum);

        System.out.println();

        System.out.printf("%-10s%-10.4f", "Средняя", (double) quartSum / (staffAmount * quart));


    }

}