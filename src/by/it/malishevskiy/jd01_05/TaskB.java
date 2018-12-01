package by.it.malishevskiy.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y = 0;
        for (double a = 0; a <= 2 ; a += 0.2) {
            for (double x = 1; x < 7; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При а=%3.2f Сумма y=%g\n", a, y);
            y = 0;
        }
    }

    private static void step2() {
        for (double x = -6; x < 2 ; x = x + 0.5) {
            double b;
            if(-2 < x/2 && x/2 <= -1){
                b = sin(x * x);
            }
            else if(-1 < x/2 && x/2 < 0.2){
                b = cos(x * x);
            }
            else if(x/2 == 0.2){
                b = 1/tan (x * x);
            }
            else {
                System.out.printf("При x/2 = %.2f вычисления не определены\n", x/2);
                continue;
            }
            double a = log10(abs(b + 2.74));
            System.out.printf("При x / 2 = %.2f alpha = %f\n", x / 2, a);
        }
    }
}
