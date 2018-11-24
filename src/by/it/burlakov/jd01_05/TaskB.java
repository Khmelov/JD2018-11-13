package by.it.burlakov.jd01_05;
import static java.lang.Math.*;
public class TaskB {

    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1(){
        for (double a = 0; a <= 2 ; a = a + 0.2 ) {
        double sum = 0;
            for (int x = 1; x < 7; x++) {
               sum += (pow(7, a) - cos(x));
            }
            System.out.printf("При a = %.2f Cумма = %f\n" , a , sum);
        }
    }
    private static void step2(){

        for (double x = -6; x < 2 ; x = x + 0.5) {
            double beta;
            if(x / 2 > -2 && x / 2 <= -1 ){
                beta = sin(x * x);
            } else if(x / 2 > -1 && x / 2 < 0.2){
                beta = cos(x * x);
            } else if(x / 2 == 0.2){
                beta = 1 / tan (x * x);
            } else {
                System.out.printf("При x / 2 = %.2f вычисления не определены\n", x / 2);
                continue;
            }
            double alpha = log10(abs(beta + 2.74));

            System.out.printf("При x / 2 = %.2f alpha = %f\n", x / 2, alpha);
        }
    }
}
