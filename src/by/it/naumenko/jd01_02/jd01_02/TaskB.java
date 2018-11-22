package by.it.naumenko.jd01_02.jd01_02;

import java.util.Scanner;

/**
 * Created by user on 15.11.2018.
 */
public class TaskB {
    static void step1() {
        int n = 5;
        for (int i = 1; i <= n * n; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0)
                System.out.println();

        }

    }

    static void step2(int mounth) {
        switch (mounth) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }

    }

    static void step3(double a, double b, double c) {
        double dec = b * b - 4 * a * c;
        if (dec == 0) {
            double x = -b / (2 * a);
            System.out.println(x);
        } else if (dec > 0) {
            double x1 = (-b + Math.sqrt(dec)) / (2 * a);
            double x2 = (-b - Math.sqrt(dec)) / (2 * a);
            System.out.println(x1 + " " + x2);
        } else
            System.out.println("корней нет");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        step1();
        int mounth = sc.nextInt();
        step2(mounth);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);


    }
}
