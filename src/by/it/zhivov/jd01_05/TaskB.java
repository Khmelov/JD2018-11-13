package by.it.zhivov.jd01_05;
import static java.lang.Math.*;
public class TaskB {

    private static void step1() {
        for (double a = 0; a <= 2 ; a += 0.2) {
            double sum=0;
            for (int x = 1; x <= 6; x++) {
                double y = pow(7, a)-cos(x);
                sum += y;
            }
            System.out.printf("При а=%1.2f Сумма y=%g%n", a, sum);
        }
    }

    public   static void step2() {
        for (double x = -6; x <= 2; x += 0.5) {
            double b = 0;
            if (x / 2 <= -2 || x / 2 > 0.2) {
                System.out.printf("При x/2=%1.2f вычисления не определены%n", x / 2);
            }
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%1.2f a=%g%n", x / 2, a);
            }
            if (x / 2 > -1 && x / 2 < 0.2) {
                b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%1.2f a=%g%n", x / 2, a);
            }
            if (x / 2 == 0.2){
                b = 1 / tan(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%1.2f a=%g%n", x / 2, a);
            }
        }
    }
    public static void main(String[] args) {
        step1();
        step2();
    }
}
