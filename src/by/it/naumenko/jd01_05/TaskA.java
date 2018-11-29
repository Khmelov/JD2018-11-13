package by.it.naumenko.jd01_05;

import static java.lang.StrictMath.*;

public class TaskA {
    static void unit1_1(double x, double a) {
        double rezultat = cos(pow(((x * x) + (PI / 6)), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        print(rezultat, x, a);
    }

    static void unit1_2(double x, double a) {
        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log((a - 1.12 * x) / 4);
        double rezultat = part1 - part2 - part3;
        print(rezultat, x, a);
    }

    static void print(double rezultat, double x, double a) {
        System.out.printf("rez = %f при x = %2.1f, a = %5.3f\n", rezultat, x, a);
    }

    static void unit2_1(double x, double a) {
        double part1 = tan(pow(x + a, 2));
        double part2 = pow((x + 1.5), 1 / 3.0);
        double part3 = x * pow(a, 5);
        double part4 = a / log(x * x);
        double rezult = part1 - part2 + part3 - part4;
        print(rezult, x, a);
    }

    static void unit2_2(double x, double a) {
        double rezult = tan(pow(x + a, 2)) - pow(x + 1.5, 1 / 3.0) + x * pow(a, 5) - a / log(x * x);
        print(rezult, x, a);
    }

    static void unit3_1(double x, double a){
        while (a<=12){
            double rezult=exp(a*x)-3.45*a;
            print(rezult,x,a);
            a+=3.75;
        }

    }


    public static void main(String[] args) {
        unit1_1(0.3, 756.13);
        unit1_2(0.3, 756.13);
        System.out.println("-------------------------------");
        unit2_1(1.21, 0.371);
        unit2_2(1.21, 0.371);
        System.out.println("-------------------------------");
        unit3_1(12.1,-5.0);

    }
}
