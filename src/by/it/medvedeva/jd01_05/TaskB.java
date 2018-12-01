package by.it.medvedeva.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }




    private static void step1() {
        double a = 0;
        double deltaa = 0.2;
        double y;
        while (a <= 2) {
            y = 0;
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("%g %g\n", a, y);

            a += deltaa;
        }
    }

    private static void step2(){}


}
