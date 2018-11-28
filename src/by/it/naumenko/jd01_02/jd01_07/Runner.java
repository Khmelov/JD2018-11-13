package by.it.naumenko.jd01_02.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1=new Scalar(12);
        Scalar v11 = new Scalar(3.12);
        Var v12 = new Scalar(v11);
        Var v13 = new Scalar("1.0");

        Var v2 = new Vector(new double[]{1.0,2.0,3.0});
        Vector v21 = new Vector(new double[]{2.0,22.0,33.0});
        Var v22 = new Vector(v21);
        Var v23 = new Vector("{1.0,2.0,4.0}");


        System.out.println(v1);
        System.out.println(v11);
        System.out.println(v12);
        System.out.println(v13);

        System.out.println(v2);
        System.out.println(v21);
        System.out.println(v22);
        System.out.println(v23);
    }
}
