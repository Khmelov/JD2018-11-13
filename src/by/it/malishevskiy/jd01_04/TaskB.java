package by.it.malishevskiy.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
            System.out.println("Введите число людей:");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("Введите %d фамилий людей\n", n);
            String[] lastNames = new String[n];
            for (int i = 0; i < n; i++) {
                lastNames[i] = scanner.nextLine();
            }
            int down = 4; // Количество кварталов
            int[][] kvartal = new int[n][down];
            for (int i = 0; i < n; i++) {
                System.out.println("Введите зарплату для " + lastNames[i]);
                for (int j = 0; j < down; j++) {
                    kvartal[i][j] = scanner.nextInt();
                }
            }
            int[] finall = new int[n];

            System.out.printf("%1$s%1$s%1$s%1$s%1$s%1$s\n", "----------");
            System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
            for (int i = 0; i < n; i++) {
                System.out.printf("%8s: ", lastNames[i]);
                for (int j = 0; j < down; j++) {
                    System.out.printf("%-10d", kvartal[i][j]);
                    finall[i] += kvartal[i][j];
                }
                System.out.printf("%-10d\n", finall[i]);
            }
            System.out.printf("%1$s%1$s%1$s%1$s%1$s%1$s\n", "----------");
            int q = 0;
            for (int i = 0; i < n; i++) {
                q += finall[i];
            }
            System.out.printf("%-8s  %-10d\n", "Итого", q);
            System.out.printf("%-8s  %-9.6f\n", "Средняя", (double) q / (n * down));
        }
    }