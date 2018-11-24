package by.it.naumenko.jd01_02.jd01_05;

import static java.lang.StrictMath.*;


public class TaskB {
//    static void unit1(int x) {
//        double rezult = 0.0;
//        for (int i = 1; i <= x; i++) {
//            double a = 0.0;
//            while (a <= 2) {
//                rezult += (pow(7, a) - cos(i));
//                print(a, rezult);
//                a += 0.2;
//            }
//        }
//    }

    static void unit1(int x) {
        double rezult = 0.0;
        double a = 0.0;
        while (a <= 2) {
            double sum = 0.0;
            for(int i=1;i<=x;i++) {
                sum = (pow(7, a) - cos(i));
                rezult+=sum;
            }

            print(a, rezult);
            a += 0.2;
        }
    }

    static void unit2(double x) {
        double rezultat = 0.0;
        double beta = 0.0;
        while (x < 2) {
            x += 0.5;
            if ((x / 2.0 > -2) && (x / 2.0 <= -1)) {
                beta = sin(x * x);
            } else if ((x / 2.0 > -1) && (x / 2.0 < 0.2)) {
                beta = cos(x * x);
            } else if (x / 2.0 == 0.2)
                beta = cos(x * x) / sin(x * x);
            rezultat = log10(abs(beta + 2.74));
            if ((beta == 0) || (beta == 1)) {
                System.out.println("вычисления не определены");
            } else
                printUnit2(x / 2, rezultat, beta);

        }

    }

    static void print(double a, double rezultat) {
        System.out.printf("При а=%1.2f Сумма y = %e\n", a, rezultat);
    }

    static void printUnit2(double a, double rezultat, double beta) {
        System.out.printf("При x/2=%1.2f Бетта = %f a = %f\n", a, beta, rezultat);
    }

    public static void main(String[] args) {
        unit1(6);
        System.out.println("-----------------------------------------");
        unit2(-6);
    }
}
