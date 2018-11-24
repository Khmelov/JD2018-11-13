package by.it.nickgrudnitsky.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        step1();
        step2(month);
        step3(a, b, c);
    }

    static void step1() {
        int number = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }

    static void step2(int month) {
        switch (month) {
            case 1:
                System.out.print("январь");
                break;
            case 2:
                System.out.print("февраль");
                break;
            case 3:
                System.out.print("март");
                break;
            case 4:
                System.out.print("апрель");
                break;
            case 5:
                System.out.print("май");
                break;
            case 6:
                System.out.print("июнь");
                break;
            case 7:
                System.out.print("июль");
                break;
            case 8:
                System.out.print("август");
                break;
            case 9:
                System.out.print("сентябрь");
                break;
            case 10:
                System.out.print("октябрь");
                break;
            case 11:
                System.out.print("ноябрь");
                break;
            case 12:
                System.out.print("декабрь");
                break;
            default:
                System.out.print("нет такого месяца");
        }
    }

    static void step3(double a, double b, double c) {
        double dis = b * b - 4 * a * c;
        if (a==0) {
            System.out.print("корней нет");
            return;
        }
        if (dis < 0) {
            System.out.print("корней нет");
        } else {
            if (dis == 0) {
                double x = -b / (2 * a);
                System.out.print(x);
            } else {
                double x1 = (-b + Math.sqrt(dis)) / (2 * a);
                double x2 = (-b - Math.sqrt(dis)) / (2 * a);
                System.out.print(x1+""+x2);
            }
        }
    }
}
