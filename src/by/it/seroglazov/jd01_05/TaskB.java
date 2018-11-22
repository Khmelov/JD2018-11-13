package by.it.seroglazov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        Task4();
        Task5();
    }

    private static void Task4() {
        double a = 0;
        double da = 0.2;
        double y;
        while (a <= 2) {
            y = 0;
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("%g %g\n", a, y);

            a += da;
        }
    }

    private static double betta(double x) {
        double h = x / 2;
        if (h > -2 && h <= -1) {
            return sin(x * x);
        } else if (h > -1 && h < 0.2) {
            return cos(x * x);
        } else if (abs(h - 0.2) < 0.000000001) { // if h == 0.2
            double t = tan(x * x);
            if (abs(t) < 0.000000001) { // if tan == 0
                return Double.NaN;
            } else { // if tan != 0
                return 1 / t;
            }
        } else return Double.NaN;
    }

    private static void Task5() {
        double x = -5.5;
        double dx = 0.5;
        double a;
        double b;
        while (x < 2) {
            b = betta(x);
            if (Double.isNaN(b)) {
                System.out.printf("%g вычисления не определены\n", x / 2);
            } else {
                a = log10(abs(b + 2.74));
                System.out.printf("%g %g\n", x / 2, a);
            }
            x += dx;
        }
    }


}
























