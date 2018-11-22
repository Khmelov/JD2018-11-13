package by.it.seroglazov.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        Task1();
        Task2();
        Task3();

    }

    private static void Task1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log((a - 1.12 * x) / 4);
        double z = part1 - part2 - part3;
        System.out.println(z);
    }

    private static void Task2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a + b, 2)) - pow(a + 1.5, 1.0 / 3) + a * pow(b, 5) - b / log(a * a);
        System.out.println(y);
    }

    private static void Task3() {
        double a = -5;
        double x = 12.1;
        double da = 3.75;
        double f;
        while (a <= 12){
            f = pow(E, a * x) - 3.45 * a;
            System.out.printf("%g %g\n",a, f);
            a += da;
        }
    }

}
