package by.it.skarpovich.jd01_05;

import static java.lang.Math.*;

class TaskB {
    public static void main(String[] args) {
        program1();
        program2();
    }

    //B1
    static void program1() {
        final double delta = 0.2;
        double y = 0;
        for (double a = 0; a <= 2; a += delta) {
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("%-5s%-5.2f%4s%-5g\n", "При a=", a, "y=", y);
        }
        System.out.println();
    }

    //B2
    static void program2() {
        double delta = 0.5;
        double beta = 0;
        double alfa;

        for (double x = -6; x < 2; x += delta) {
            double k = x / 2;
            if (x == -6) {  //Отбрасываем значение x=6.
                continue;
            }
            if (k <= -2 || k > 0.2) { //Проверяем не находится ли x\2 за пределами условий;
                System.out.printf("%-5s%-5.2f%13s\n", "При x/2=", k, "решений нет");
                continue;
            }

            if (k > -2 && k <= -1) {
                beta = sin(x * x);
            } else if (k > -1 && k < 0.2) {
                beta = cos(x * x);
            } else if (k == 0.2) {
                beta = 1.0 / tan(x * x);
            }
            alfa = log10(abs(beta + 2.74));
            System.out.printf("%-5s%-5.2f%7s%-5g\n", "При x/2=", k, "alfa=", alfa);
        }
    }
}




