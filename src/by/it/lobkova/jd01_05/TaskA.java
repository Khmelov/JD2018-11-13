package by.it.lobkova.jd01_05;
import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        ste2();
        step3();
    }

    static void step1(){
        double z;
        double a = 756.13;
        double x = 0.3;

        z = cos(pow((x*x + PI/6), 5));
        z -= sqrt(x * pow(a, 3));
        z -= log(abs((a - 1.12  * x) / 4));
        System.out.println("Ответ = " + z);

    }

    static void ste2(){
        double y;
        double a = 1.21;
        double b = 0.371;

        y = tan(pow(a+b,2)) - cbrt(a + 1.5) + a * pow(b, 5) - b/log(pow(a,2));
        System.out.println("Ответ = " + y);
    }

    static void step3(){
        double x = 12.1;
        double f;

        for (double a = -5; a <= 12; a += 3.75) {
            f = exp(a*x) - 3.45 * a;
            System.out.println("При a = " + a + " f = " + f);
        }
    }
}
