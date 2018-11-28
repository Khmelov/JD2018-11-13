package by.it.naumenko.jd01_02.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var s1=new Scalar(12);
        Scalar s11 = new Scalar(3.12);
        Var s12 = new Scalar(s11);
        Var s13 = new Scalar("1.0");

        Var v2 = new Vector(new double[]{1.0,2.0,3.0});
        Vector v21 = new Vector(new double[]{2.0,22.0,33.0});
        Var v22 = new Vector(v21);
        Var v23 = new Vector("{1.0,2.0,4.0}");

        Var m3 = new Matrix(new double[][]{{1.0,2.0},{3.0,4.0}});
        Matrix m31 = new Matrix(new double[][]{{2.0,22.0},{33.0,44.0}});
        Var m33 = new Matrix(m31);

        System.out.println(s1);
        System.out.println(s11);
        System.out.println(s12);
        System.out.println(s13);

        System.out.println(v2);
        System.out.println(v21);
        System.out.println(v22);
        System.out.println(v23);

        System.out.println(m3);
        System.out.println(m31);
        System.out.println(m33);
    }
}
