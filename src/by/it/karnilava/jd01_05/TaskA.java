package by.it.karnilava.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {

        subtask1();

        subtask2();

        subtask3();


    }

    private static void subtask3() {
        for (double a = -5; a <= 12; a = a + 3.75) {
            double x = 12.1;
            double fpart1 = pow(E, a * x);
            double fpart2 = 3.45 * a;
            double f = fpart1 - fpart2;
            System.out.println(f + " " + a);
        }
    }

    private static void subtask2() {
        double a = 1.21;
        double b = 0.371;
        double part1 = tan(pow(a + b, 2));
        double part2 = pow((a + 1.5), (1.0 / 3));
        double part3 = a * pow(b, 5);
        double part4 = b / (log(pow(a, 2)));
        double y = part1 - part2 + part3 - part4;
        System.out.println(y);
    }

    private static void subtask1() {
        double x = 0.3;
        double a = 756.13;
        double m = cos(pow((pow(x, 2) + (PI / 6)), 5));
        double n = sqrt(x * a * a * a);
        double k = log(abs((a - 1.12 * x) / 4));
        double z = m - n - k;

        System.out.println(z);
        z = cos(pow((pow(x, 2) - PI / 6), 5)) - sqrt(x * a * a * a) - log(abs((a - 1.12 * x) / 4));
        System.out.println(z);
    }


}
