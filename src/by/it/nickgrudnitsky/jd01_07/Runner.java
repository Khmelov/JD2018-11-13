package by.it.nickgrudnitsky.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar s1 = new Scalar(3.1415);
        Var s2 = new Scalar("3.1415");
        Var s3 = new Scalar(s1);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        Vector v1 = new Vector(new double[]{1.0,2.0,4.0});
        Var v2 = new Vector(v1);
        Vector v3 = new Vector("{1, 2, 4}");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }
}
