package by.it.karnilava.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        Subtask4();

        Subtask5();

    }

    private static void Subtask5() {
        for (double x = -5.5; x < 2; x = x + 0.5) {
            double beta = 0;
            if ((x / 2) > -3 && (x / 2) <= -2) {
                System.out.println("При x/2=" + x / 2 + " вычисления не определены");

            }
            if ((x / 2) > -2 && (x / 2) <= -1) {
                beta = sin(pow(x, 2));
                double alpha = log10(abs(beta + 2.74));
                System.out.println("При x/2=" + x / 2 + " a = " + alpha);
            } else if ((x / 2) > -1 && (x / 2) < 0.2) {
                beta = cos(pow(x, 2));
                double alpha = log10(abs(beta + 2.74));
                System.out.println("При x/2=" + x / 2 + " a = " + alpha);
            } else if ((x / 2) == 0.2) {
                beta = 1 / tan(pow(x, 2));
                double alpha = log10(abs(beta + 2.74));
                System.out.println("При x/2=" + x / 2 + " a = " + alpha);

            } else if ((x / 2) > 0.2) {
                System.out.println("При x/2=" + x / 2 + " вычисления не определены");

            }


        }
    }

    private static void Subtask4() {
        double y = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (int x = 1; x <= 6; x++) {
                double w = pow(7, a) - cos(x);
                y = w + y;
                System.out.println(y);


            }

        }
    }
}
