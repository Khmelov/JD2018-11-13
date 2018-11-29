package by.it.berdnik.jd01_05;

import static java.lang.Math.pow;

public class TaskC {

    public static void main(String[] args) {
        int n = 20;
        double a = 5.33, x, b = 9;
        x = (b - a) / n;
        x = a;

        double[] mas = new double[n];
        int i = 0;
        if (x <= b) {
            mas[i++] = pow(x * x + 4.5, 1.0 / 3);
        }

        masA(mas, "A", 5);
        int aA = 0;
        for (double j : mas) {
            if (j > 3.5) aA++;
        }

        double[] masB = new double[aA];
        int bB = 0;
        for (double k : mas) {
            if (k > 3.5) {
                masB[bB++] = k;
            }
        }
        masA(masB, "B", 5);
    }

    public static void masA(double[] mas, String string, int st) {
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%s [%-2d] = %-10.5f", string, i, mas[i]);
        }
    }
}
