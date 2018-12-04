package by.it.evenchik.jd01_07;

public class Runner {

    public static void main(String[] args) {

        Var v1 = new Scalar(3.14);
        Var v2 = new Vector(new double[]{1.0,2.0, 3.0});
        Var v3 = new Vector(new Vector(new double[]{1.0,2.0}));
        Var v4 = new Vector(new String("{1.0,2.0,4.0}"));
        Var chtougodno = new Scalar(new Scalar(33.3));
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(chtougodno);

    }
}
