package by.it.markelov.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }


    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double part1, part2, part3, z;

        part1 = cos(pow((x * x + PI / 6), 5));
        part2 = sqrt(x * pow(a, 3));
        part3 = log(abs((a - 1.12 * x) / 4));

        z = part1 - part2 - part3;
        System.out.println(z);

        z = cos(pow((x * x + PI / 6), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        System.out.println(z);
    }

    private static void step2() {
        double a;
        double part1;
        double part2;
        double part3;
        a = 1.21;
        double b = 0.371;
        double y, part4;

        part1 = tan(pow((a + b), 2));
        part2 = pow((a + 1.5), 1 / 3.0);
        part3 = a * pow(b, 5);
        part4 = b / (log(pow(a, 2)));

        y = part1 - part2 + part3 - part4;
        System.out.println(y);

        y = tan(pow((a + b), 2)) - cbrt(a + 1.5) + a * pow(b, 5) - b / (log(a * a));
        System.out.println(y);
    }

    private static void step3() {
        double x = 12.1;
        for (double a = -5; a <= 12; a += 3.75) {
            double f = (exp(a * x) - 3.45 * a);
            System.out.printf("При а = %6.2f f = %g\n", a, f);
        }
    }
}
