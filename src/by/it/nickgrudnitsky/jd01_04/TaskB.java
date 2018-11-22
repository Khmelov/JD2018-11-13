package by.it.nickgrudnitsky.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] array = new String[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.next();
        }
        int[][] payment = new int[n][4];
        for (int i = 0; i < payment.length; i++) {
            for (int i1 = 0; i1 < payment[0].length; i1++) {
                payment[i][i1] = scanner.nextInt();
            }
        }
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-5s", "Фамилия",
                "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        for (int i = 0; i < array.length; i++) {

            System.out.printf("%-10s%-10d%-10d%-10d%-10d%-5d", array[i], payment[i][0], payment[i][1],
                    payment[i][2],payment[i][3], payment[i][0]+payment[i][1]+payment[i][2]+payment[i][3]);
            System.out.println();

        }

        int wholePayment = 0;
        for (int i = 0; i < payment.length; i++) {
            for (int i1 = 0; i1 < payment[0].length; i1++) {
                wholePayment += payment[i][i1];
            }
        }
        double whole = (double)wholePayment;
        double averagePayment = (wholePayment/(n*4.0));

        System.out.printf("%-10s%-10d", "Итого", wholePayment);
        System.out.printf("%-10s%-10.4f", "Средняя", averagePayment);

    }
}