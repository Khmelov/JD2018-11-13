package by.it.kovalyova.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите число людей");
        Scanner scanner = new Scanner(System.in);
        int peopleQuant = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Введите %d фимилий сотрудников\n ", peopleQuant);
        String[] lastname = new String[peopleQuant];
        for (int i = 0; i < peopleQuant ; i++) {
            lastname[i] = scanner.nextLine();
        }
         int quarter = 4;
        int[][] salary = new int[peopleQuant][quarter];
        for (int i = 0; i < peopleQuant; i++) {
            System.out.println("Введите зарплату "+ lastname[i]);
            for (int j = 0; j < quarter; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        int[] sum = new int[peopleQuant];
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия",
        "Квартал1", "Квартал2","Квартал3", "Квартал4", "Итого");
        for (int i = 0; i < peopleQuant; i++) {
            System.out.printf("%s: ", lastname[i]);
            for (int j = 0; j < quarter; j++) {
                System.out.printf("%-11d", salary[i][j]);
                sum [i] +=salary[i][j];
            }
            System.out.printf("%-10d\n", sum[i]);
        }
        int allPeopleSal = 0;
        for (int i = 0; i < peopleQuant; i++) {
            allPeopleSal += sum[i];
        }
        System.out.printf("%-8s %-10d\n", "All: ", allPeopleSal);
        System.out.printf("%-8s %-9.5f\n", "Average:", (double) allPeopleSal/(peopleQuant*quarter));
    }
}
