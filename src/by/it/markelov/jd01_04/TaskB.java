package by.it.markelov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        String lastName[] = new String[n];
        for (int i = 0; i < lastName.length; i++) {
            lastName[i] = scr.next();
        }

        int salary[][] = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + lastName[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scr.nextInt();

            }
        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("%-8s  %-8s  %-8s  %-8s  %-8s  %-6s\n", "Фамилия", "Квартал1",
                "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("--------------------------------------------------------");
        double countOfQuarter=0;
        int sum=0;
        int total=0;
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%7s:  ", lastName[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d", salary[i][j]);
                sum+=salary[i][j];
                countOfQuarter++;
            }
            System.out.printf("%-8d", sum);
            total+=sum;
            System.out.println();
            sum=0;
        }
        System.out.println("--------------------------------------------------------");

        System.out.printf("%-7s:  ", "Итого");
        System.out.printf("%-10d\n", total);
        System.out.printf("%-7s:  ", "Средняя");
        double avg=total/countOfQuarter;
        System.out.printf("%-10.4f\n", avg);




    }


}



