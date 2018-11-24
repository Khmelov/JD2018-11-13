package by.it.mnovikov.jd01_04;

import java.util.Scanner;


/**
 * Created by user on 20.11.2018.
 */
public class TaskB {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] surname = new String[n];
        for (int i = 0; i < surname.length; i++) {
            surname[i] = sc.nextLine();
        }

        int[][] zp = new int[n][4];
        int[] sum = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + surname[i]);
            for (int j = 0; j < 4; j++) {
                zp[i][j] = sc.nextInt();
                sum [i] += zp[i][j];
            } total+=sum[i];
        }

        System.out.printf("%1$s%1$s%1$s%1$s%1$s%1$s\n", "----------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.printf("%1$s%1$s%1$s%1$s%1$s%1$s\n", "----------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%8s: %-10d%-10d%-10d%-10d%-10d\n", surname[i], zp[i][0], zp[i][1], zp[i][2], zp[i][3], sum[i]);
        }
        System.out.printf("%1$s%1$s%1$s%1$s%1$s%1$s\n", "----------");
        System.out.printf("%-10s%-10d\n", "Итого", total);
        System.out.printf("%-10s%-9.6f", "Средняя", (double)total/(4*n));

    }
}

