package by.it.nickgrudnitsky.jd01_07;

public class Runner {
    public static void main(String[] args) {
        start1();
        start2();
        start3();
    }

    private static void start3() {
        Matrix m1 = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        Var m2 = new Matrix(m1);
        Var m3 = new Matrix("{{1,2},{3,4}}");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }

    private static void start2() {
        Vector v1 = new Vector(new double[]{1.0, 2.0, 4.0});
        Var v2 = new Vector(v1);
        Vector v3 = new Vector("{1, 2, 4}");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }

    private static void start1() {
        Scalar s1 = new Scalar(3.1415);
        Var s2 = new Scalar("3.1415");
        Var s3 = new Scalar(s1);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
