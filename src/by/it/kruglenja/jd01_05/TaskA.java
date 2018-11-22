package by.it.kruglenja.jd01_05;

/**
 * Created by user on 22.11.2018.
 */
public class TaskA {
    public static void main(String[] args) {
        mathA();
    }
    static void mathA(){
        double res1;
        double a = 756.13;
        double x = 0.3;

        double q = Math.cos(Math.pow((Math.pow(x, 2) + Math.PI / 6), 5));
        double w = Math.sqrt(x * Math.pow(a, 3));
        double e = Math.log(Math.abs((a - 1.12 * x) / 4));

        res1 = q - w - e;

        double res2 = Math.cos(Math.pow((Math.pow(x, 2) + Math.PI / 6), 5)) - Math.sqrt(x * Math.pow(a, 3)) -
                - Math.log(Math.abs((a - 1.12 * x) / 4));
        System.out.println(res1 + " " + res2);
    }
    static void mathB(){

    }
}
