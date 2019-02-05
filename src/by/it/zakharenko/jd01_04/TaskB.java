package by.it.zakharenko.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите число людей:");
        Scanner scanner = new Scanner(System.in);
        int employeeAmount = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Введите %d фамилий людей\n", employeeAmount);
        String[] lastNames = new String[employeeAmount];
        for (int i = 0; i < employeeAmount; i++) {
            lastNames[i] = scanner.nextLine();
        }
        final int quarterAmount = 4; // Количество кварталов
        int[][] salary = new int[employeeAmount][quarterAmount];
        for (int i = 0; i < employeeAmount; i++) {
            System.out.println("Введите зарплату для " + lastNames[i]);
            for (int j = 0; j < quarterAmount; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        int[] total = new int[employeeAmount];

        /*int employeeAmount = 3;
        String[] lastNames = {"Серов", "Петров", "Баширов" };
        int[][] salary = {{12, 45, 8, 4}, {7, 230, 18, 2}, {5, 44, 2, 12}};
        final int quarterAmount = 4; // Количество кварталов
        int[] total = new int[employeeAmount];*/


        System.out.printf("%1$s%1$s%1$s%1$s%1$s%1$s\n", "----------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        for (int i = 0; i < employeeAmount; i++) {
            System.out.printf("%8s: ", lastNames[i]);
            for (int j = 0; j < quarterAmount; j++) {
                System.out.printf("%-10d", salary[i][j]);
                total[i] += salary[i][j];
            }
            System.out.printf("%-10d\n", total[i]);
        }
        System.out.printf("%1$s%1$s%1$s%1$s%1$s%1$s\n", "----------");
        int totalAllEmployee = 0;
        for (int i = 0; i < employeeAmount; i++) {
            totalAllEmployee += total[i];
        }
        System.out.printf("%-8s  %-10d\n", "Итого", totalAllEmployee);
        System.out.printf("%-8s  %-9.6f\n", "Средняя", (double) totalAllEmployee / (employeeAmount * quarterAmount));
    }
}


























