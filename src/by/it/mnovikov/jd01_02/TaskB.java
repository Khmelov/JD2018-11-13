package by.it.mnovikov.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        step1();

//        for (int month = 1; month < 13; month++) {
        int month = sc.nextInt();
        step2(month);
//        }
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);
    }

    static void step1() {
        int count = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                count++;
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }

    static void step2(int month) {
        switch (month) {
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
        double D = b * b - 4 * a * c;
        if (D < 0) {
            System.out.println("корней нет");
        } else if (D == 0) {
            System.out.println((-b + Math.sqrt(D))/(2*a));
        } else System.out.println(((-b + Math.sqrt(D))/(2*a)) + " " + ((-b - Math.sqrt(D))/(2*a)));
    }
}
