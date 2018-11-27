package by.it.denisova.jd01_05;

import java.lang.Math.*;
import java.util.Scanner;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {



        task4funcSum();
        task5();
    }

    private static void task4funcSum() {

       double f = 7;
       // double x = 1;

        for (double j = 0; j <= 2; j += 0.2) {
            double sum = 0;
            for (int i = 1; i <= 6; i++) {
                double y = pow(f, j) - cos(i);
                sum = sum + y;
            }
            System.out.printf("При a =%3.2f Сумма y = %f  \n",j,sum);
        }

    }

    private static void task5(){
        double b = 0;

        for (double i = -5.5; i <2 ; i=i+0.5) {

            if(i/2.0 >-2 && i/2.0 <= -1){
                b = sin(i*i);
                double a = log10(abs(b+2.74));
                System.out.printf("При x/2=%-7.2f a = %f \n",i/2, a);
            }
            else if (i/2.0 > -1 && i/2.0 < 0.2){
                b = cos(i*i);
                double a = log10(abs(b+2.74));
                System.out.printf("При x/2=%-7.2f a = %f \n",i/2.0, a);
            }
            else if (i/2.0 == 0.2){
                b = 1/tan(i*i);
                double a = log10(abs(b+2.74));
                System.out.printf("При x/2=%-7.2f a = %f \n",i/2, a);
            }
            else {

                System.out.printf("При x/2=%-7.2f вычисления не определены  \n",i/2 );
            }
        }
    }
}
