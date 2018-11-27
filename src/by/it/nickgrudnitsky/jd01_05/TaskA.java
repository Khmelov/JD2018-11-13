package by.it.nickgrudnitsky.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task3() {
        double x = 12.1;
        double f;
        for (double a = -5.0; a <= 12; a += 3.75) {
            f = pow(E, a * x) - 3.45 * a;
            System.out.printf("При а= %5.2f f=%e\n", a, f);
        }
    }

    private static void task2() {
        double a = 1.21;
        double b = 0.371;
        double part1 = tan(pow((a + b), 2));
        double part2 = pow(a + 1.5, 1 / 3.0);
        double part3 = a * pow(b, 5);
        double part4 = b / log(a * a);
        double y = part1 - part2 + part3 - part4;
        System.out.println(y);
    }

    private static void task1() {
        double x = 0.3;
        double a = 756.13;
        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = pow(x * pow(a, 3), 1 / 2.0);
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.println(z);
    }
}

