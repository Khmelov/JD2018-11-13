package by.it.baidak.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] workers = new String[n];
        for(int i = 0; i < n; i++){
            workers[i] = scanner.next();
        }

        int [][] zp = new int[n][4];
        for(int i = 0; i < n; i++){
            System.out.println("Введите зарплату для " + workers[i]);
            for (int i1 = 0; i1 < 4; i1++) {
                zp[i][i1] = scanner.nextInt();
            }
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("------------------------------------------------------------");
        int[] averageSumm = new int[n];
        for (int i = 0; i < workers.length; i++) {
            int summ = 0;
            System.out.printf("%-10s", workers[i] + ":");
            for (int j = 0; j < 4; j++) {
                summ += zp[i][j];
                System.out.printf("%-10d", zp[i][j]);
            }
            averageSumm[i] = summ;
            System.out.printf("%-10d\n", summ);
        }

        System.out.println("------------------------------------------------------------");
        int allZp = 0;
        for (int i = 0; i < averageSumm.length; i++) {
            allZp += averageSumm[i];
        }
        System.out.printf("%-10s%-10d\n", "Итого", allZp);
        System.out.printf("%-10s%-10f\n", "Средняя", (double) allZp / (n * 4));
    }
}
