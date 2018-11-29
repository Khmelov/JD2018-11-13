package by.it.seroglazov.jd01_07;

public class Runner {
    public static void main(String[] args) {

        Scalar s1 = new Scalar(2.45);
        System.out.println(s1);
        Var s2 = new Scalar("22.981");
        System.out.println(s2);
        Var s3 = new Scalar(s1);
        System.out.println(s3);

        double[] d = {1,2,4};
        Vector v1 = new Vector(d);
        System.out.println(v1);
        Var v2 = new Vector("{2.3, 4.5}");
        System.out.println(v2);
        Vector v3 = new Vector(v1);
        System.out.println(v3);

        double[][] matr = {{2.0, 3, 9}, {4.75, 6, 0}, {1e2, 0xA, 010}};
        Matrix m = new Matrix(matr);
        System.out.println(m);
        Matrix m2 = new Matrix(m);
        System.out.println(m2);
        Var m3 = new Matrix("{{1, 2}, {3, 4},   {5,    6},  {7.02,100.15}}");
        System.out.println(m3);
    }
}
