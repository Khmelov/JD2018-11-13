package by.it.medvedeva.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        System.out.println("Введите количество сотрудников");
        Scanner scanner = new Scanner(System.in);
        int peopleQuant = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Введите %d фамилий сотрудников\n ", peopleQuant);
        String[] lastname = new String[peopleQuant];
        for (int i = 0; i < peopleQuant; i++) {
            lastname[i] = scanner.nextLine();
        }

        int[][] salary = new int[peopleQuant][4];
        for (int i = 0; i < peopleQuant; i++) {
            System.out.println("Введите зарплату " + lastname[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        int[] sum = new int[peopleQuant];
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Surname", "Quart1", "Quart2", "Quart3", "Quart4", "Total");
        for (int i = 0; i < peopleQuant; i++) {
            System.out.printf("%s:  ", lastname[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-11d", salary[i][j]);
                sum [i] +=salary[i][j];


            }
            System.out.printf("%-10d\n", sum[i]);

        }
        int allPeopleSal = 0;
        for (int i = 0; i <peopleQuant; i++) {
            allPeopleSal += sum[i];
            }

        System.out.printf("%-8s %-10d\n", "All: ", allPeopleSal);
        System.out.printf("%-8s %-9.5f\n", "Average:", (double) allPeopleSal/(peopleQuant*4));


    }
}