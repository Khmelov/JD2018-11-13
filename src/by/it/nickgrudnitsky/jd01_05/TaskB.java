package by.it.nickgrudnitsky.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task2() {
        double betta;
        double alpha;
        for (double x = -5.5; x < 2.0; x += 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                betta = sin(x * x);
                alpha = log10(abs(betta + 2.74));
                System.out.printf("При x/2= %4.2f альфа = %10.8e\n", x / 2, alpha);
            } else {
                if (x / 2 > -1 && x / 2 < 0.2) {
                    betta = cos(x * x);
                    alpha = log10(abs(betta + 2.74));
                    System.out.printf("При x/2= %4.2f альфа = %10.8e\n", x / 2, alpha);
                } else {
                    if (x / 2 == 0.2) {
                        betta = 1 / tan(x * x);
                        alpha = log10(abs(betta + 2.74));
                        System.out.printf("При x/2= %4.2f альфа = %10.8e\n", x / 2, alpha);
                    } else {
                        System.out.printf("При x/2= %4.2f вычиления не определены\n", x / 2);
                    }
                }
            }
        }
    }

    private static void task1() {
        double y = 0;
        for (double a = 0; a <= 2.0; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При а=%4.2f умма y = %10.9e\n", a, y);
        }
    }
}

