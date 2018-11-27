package by.it.kovalyova.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
            }

    private static void step4() {
        double sum = 0;
        for (double a = 0; a < 2; a +=0.2) {
            for (double x = 1; x <=6 ; x++) {
                double y = pow(7,a)-cos(x);
                sum +=y;
                System.out.printf("При a=%.2f и x=%.0f значение y=%g\n", a, x, sum);

            }

        }

    }
}
