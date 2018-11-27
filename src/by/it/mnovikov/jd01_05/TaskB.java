package by.it.mnovikov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        sum();
        func();
    }

    private static void sum() {
        double delta_a = 0.2;
        double sum  = 0;
        for (double a = 0; a <= 2 ; a+=delta_a) {
            for (int x = 1; x <= 6; x++) {
                sum += pow(7,a)-cos(x);
            }
            System.out.printf("%6s%1.2f%11s%g\n", "При a=", a, " Сумма y = ", sum);
        }
    }

    private static void func(){
        double betta;
        double a;
        for (double x = -6; x < 2 ; x+=0.5) {
            if (x/2.0 >-2 && x/2.0<=-1){
                betta = sin(pow(x,2));
                a = log10(abs(betta+2.74));
                System.out.printf("%8s%2.2f%5s%g\n", "При x/2=", x/2, " a = ", a);
            }else if (x/2 >-1 && x/2 < 0.2){
                betta = cos(pow(x,2));
                a = log10(abs(betta+2.74));
                System.out.printf("%8s%2.2f%5s%g\n", "При x/2=", x/2, " a = ", a);
            }else if (x/2==0.2) {
                betta = 1.0/tan(pow(x,2));
                a = log10(abs(betta+2.74));
                System.out.printf("%8s%2.2f%5s%g\n", "При x/2=", x/2, " a = ", a);
            } else System.out.printf("%8s%2.2f%25s\n", "При x/2=", x/2, " вычисления не определены");
        }
    }
}
