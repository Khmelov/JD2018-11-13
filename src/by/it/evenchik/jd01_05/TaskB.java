package by.it.evenchik.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        b1();
    }


        private static void b1() {
            double a = 0;
            double delta = 0.2;
            double y;
            while (a <= 2) {
                y = 0;
                for (int x = 1; x <= 6; x++) {
                    y += pow(7, a) - cos(x);
                }
                System.out.printf("%g %g\n", a, y);

                a += delta;
            }

        }

}



