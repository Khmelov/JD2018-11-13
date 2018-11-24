package by.it.karnilava.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        System.out.println("Введите число людей");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Введите фамилии");
        String[] mas = new String[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.next();
        }

        int[][] sal = new int[n][4];
        for (int k = 0; k < n; k++) {
            System.out.println("Введите зарплату для " + mas[k]);
            for (int i = 0; i < 4; i++) {
                int s = scanner.nextInt();
                sal[k][i] = s;
            }
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("------------------------------------------------------------");
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            int sum = sal[i][0] + sal[i][1] + sal[i][2] + sal[i][3];
            totalSum = totalSum + sum;
            System.out.printf("%-9s%-10d%-10d%-10d%-10d%-5d%n", mas[i], sal[i][0], sal[i][1], sal[i][2], sal[i][3], sum);
        }
        System.out.println("------------------------------------------------------------");

        System.out.printf("%-15s%-10d%n", "Итого", totalSum);
        System.out.printf("%-15s%-10.4f%n", "Средняя", ((double) totalSum) / (n * 4));
    }
}





