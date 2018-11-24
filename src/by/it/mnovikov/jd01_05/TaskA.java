package by.it.mnovikov.jd01_05;

import static java.lang.Math.*;

/**
 * Created by user on 22.11.2018.
 */
public class TaskA {
    public static void main(String[] args) {


        double a1 = 756.13;
        double x1 = 0.3;
        double p1 = cos(pow(pow(x1, 2) + PI / 6, 5));
        double p2 = sqrt(x1 * pow(a1, 3));
        double p3 = log(abs((a1 - 1.12 * x1) / 4));
        double z1 = p1 - p2 - p3;
        System.out.println(z1);
        double z2 = cos(pow(pow(x1, 2) + PI / 6, 5)) - sqrt(x1 * pow(a1, 3)) - log(abs((a1 - 1.12 * x1) / 4));
        System.out.println(z2);


        double a2 = 1.21;
        double b2 = 0.371;
        double y2 = tan(pow(a2 + b2, 2)) - pow(a2 + 1.5, 1.0 / 3) + a2 * pow(b2, 5) - b2 / (log(pow(a2, 2)));
        System.out.println(y2);

        double x3 = 12.1;
        double a3_delta = 3.75;
        for (double a3=-5; a3 <= 12; a3 += a3_delta) {
            double f = exp(a3 * x3) - 3.45 * a3;
            System.out.printf( "%7s%5.2f%3s%g\n" ,"При а= ", a3, " f=", f);
        }
    }
}
