package by.it.markelov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1=new Scalar(0.12345);
        Var v2=new Scalar((Scalar) v1);
        Var v3=new Scalar("0.12345");

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        v1=new Vector(new double[]{1.0,2.0,4.0});
        v2=new Vector((Vector) v1);
        v3=new Vector("{1.0, 2.0, 4.0}");

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);




    }
}
