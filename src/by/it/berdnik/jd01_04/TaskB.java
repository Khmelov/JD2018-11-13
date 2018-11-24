package by.it.berdnik.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во сотрудников: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Введите %d фамилии сотрудников:\n", n);
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = scanner.nextLine();
        }

        int quarter = 4;
        int[][] salary = new int[n][quarter];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для: " + name[i]);
            for (int j = 0; j < quarter; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        int[] total = new int[n];

        System.out.printf("%1$s%1$s%1$s%1$s%1$s%1$s\n", "----------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        for (int i = 0; i < n; i++) {
            System.out.printf("%8s: ", name[i]);
            for (int j = 0; j < quarter; j++) {
                System.out.printf("%-10d", salary[i][j]);
                total[i] += salary[i][j];
            }
            System.out.printf("%-10d\n", total[i]);
        }
        System.out.printf("%1$s%1$s%1$s%1$s%1$s%1$s\n", "----------");
        int totalAll = 0;
        for (int i = 0; i < n; i++) {
            totalAll += total[i];
        }
        System.out.printf("%-8s  %-10d\n", "Итого", totalAll);
        System.out.printf("%-8s  %-9.6f\n", "Средняя", (double) totalAll / (n * quarter));
    }
}
