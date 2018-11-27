package by.it.lobkova.jd01_05;

import static java.lang.Math.*;
public class TaskB  {
    public static void main(String[] args) {
        step1();
        step2();
    }

    static void step1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.println(y);
        }

    }

    static void step2() {
        double a = 0;
        double b = 0;
        String noResult = "";
        for (double x = -6; x < 2; x += 0.5) {
            if ((x / 2) > -2 &&(x / 2) <= -1) {
                b = sin(x * x);
            } else if ((x/2) > -1 && (x/2) < 0.2){
                b = cos(x*x);
            } else if ((x / 2) == 0.2) {
                b = 1 / tan(x * x);
            } else noResult = " вычисления не определены";

            if (noResult == "") {
                a = log10(abs(b + 2.74));
                System.out.println("При x/2=" + x / 2 + " a = " + a);
            }
            else
                System.out.println("При x/2=" + x / 2 + noResult);
            noResult = "";
        }
    }
}
