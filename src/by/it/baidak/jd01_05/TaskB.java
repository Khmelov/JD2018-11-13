package by.it.baidak.jd01_05;

import static java.lang.Math.*;
import static java.lang.Math.cos;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double sum = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (double x = 1; x <= 6; x++) {
                double y = pow(7, a) - cos(x);
                sum += y;
                System.out.printf("При а=%.2f и x=%.0f значение y=%g\n", a, x, sum);
            }
        }
    }

    private static void step2() {
        double a, b;
        for (double x = -5.5; x < 2; x+=0.5) {
            if (-2<(x/2)&&(x/2)<=-1) {
                b=sin(x*x);
                a=log10(abs(b+2.74));
                System.out.printf("При x=%.2f и b=%f значение a=%g\n", x, b, a);
            }
            else if (-1<(x/2)&&(x/2)<0.2) {
                b=cos(x*x);
                a=log10(abs(b+2.74));
                System.out.printf("При x=%.2f и b=%f значение a=%g\n", x, b, a);
            }
            else if ((x/2)==0.2) {
                b= 1.0/tan(x*x);
                a=log10(abs(b+2.74));
                System.out.printf("При x=%.2f и b=%f значение a=%g\n", x, b, a);
            }

        }
    }
}
