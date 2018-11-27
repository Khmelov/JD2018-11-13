package by.it.seroglazov.jd01_07;

public class Runner {
    public static void main(String[] args) {

        /*Scalar s1 = new Scalar(2.45);
        System.out.println(s1);
        Var s2 = new Scalar("22.981");
        System.out.println(s2);
        Var s3 = new Scalar(s1);
        System.out.println(s3);*/

        double[] d = {1.0, 2.0};
        Vector v1 = new Vector(d);
        System.out.println(v1);
        Var v2 = new Vector("{2.3, 4.5}");
        System.out.println(v2);
    }
}
