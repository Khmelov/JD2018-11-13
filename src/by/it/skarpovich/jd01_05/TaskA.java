package by.it.skarpovich.jd01_05;

import static java.lang.Math.*;


class TaskA {

    public static void main(String[] args) {
        prog1();
        prog2();
        prog3();
    }

    static void prog1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.println(z);
        z = cos(pow(x * x + PI / 6, 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        System.out.println(z);
    }

    static void prog2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a + b, 2)) - pow(a + 1.5, 1.0 / 3) + a * pow(b, 5) - b / log(a * a);
        System.out.println(y);
        System.out.println();
    }

    static void prog3() {
        double x = 12.1;
        final double delta = 3.75;
        for (double a = -5; a <= 12; a += delta) {
            double f = exp(a * x) - 3.45 * a;

            System.out.printf("%-5s%-5.2f%4s%-5.6g\n", "При a=", a, "f=", f);
        }
    }
}

