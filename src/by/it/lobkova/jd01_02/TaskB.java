package by.it.lobkova.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        step1();

        int mounth;
        mounth = scanner.nextInt();
        step2(mounth);

        double a, b, c;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        step3(a, b, c);
    }

    private static void step1() {
        for (int a = 1; a <= 25; a++) {
            if (a % 5 == 0) {
                System.out.println(a + " ");
            } else {
                System.out.print(a + " ");
            }
        }
    }

    private static void step2(int mounth) {
        switch (mounth) {
            case 1: {
                System.out.println("январь");
                break;
            }
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3: {
                System.out.println("март");
                break;
            }
            case 4: {
                System.out.println("апрель");
                break;
            }
            case 5: {
                System.out.println("май");
                break;
            }
            case 6: {
                System.out.println("июнь");
                break;
            }
            case 7: {
                System.out.println("июль");
                break;
            }
            case 8: {
                System.out.println("август");
                break;
            }
            case 9: {
                System.out.println("сентябрь");
                break;
            }
            case 10: {
                System.out.println("октябрь");
                break;
            }
            case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default: {
                System.out.println("нет такого месяца");
            }
        }
    }

    private static void step3(double a, double b, double c) {
        double discriminant;
        double x1, x2;
        discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant < 0) System.out.println("корней нет");

        if (discriminant == 0) {
            x1 = (b * (-1)) / (2 * a);
            System.out.println("x1 = " + x1);
        }

        if (discriminant > 0) {
            x1 = ((b * -1) + Math.sqrt(discriminant)) / (2 * a);
            x2 = ((b * -1) - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("x1 = " + x1 + " x2 = " + x2);
        }
    }
}


