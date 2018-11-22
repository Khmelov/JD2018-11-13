package by.it.kruglenja.jd01_05;

/**
 * Created by user on 22.11.2018.
 */
public class TaskA {
    public static void main(String[] args) {
        mathA();
        mathB();
    }
    private static void mathA(){
        double res1;
        double a = 756.13;
        double x = 0.3;

        double q = Math.cos(Math.pow((Math.pow(x, 2) + Math.PI / 6), 5));
        double w = Math.sqrt(x * Math.pow(a, 3));
        double e = Math.log(Math.abs((a - 1.12 * x) / 4));

        res1 = q - w - e;

        double res2 = Math.cos(Math.pow((Math.pow(x, 2) + Math.PI / 6), 5)) - Math.sqrt(x * Math.pow(a, 3))
                - Math.log(Math.abs((a - 1.12 * x) / 4));
        System.out.println(res1 + " " + res2);
    }
    private static void mathB(){
        double res1;
        double a = 1.21;
        double b = 0.371;

        double q = Math.tan(Math.pow(a + b, 2));
        double w = Math.pow((a + 1.5), 1.0/3);
        double r = a * Math.pow(b, 5);
        double e = b / (Math.log(Math.pow(a, 2)));

        res1 = q - w + r - e;
        System.out.println(res1);
    }
     private static  void mathC(){
         double x = 12.1;
         
     }
}
